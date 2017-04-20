package poojab26.nearbyrestaurants;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import poojab26.nearbyrestaurants.Model.R_Details;
import poojab26.nearbyrestaurants.Model.RestaurantList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pblead26 on 18-Apr-17.
 */

public class RestaurantsActivity extends AppCompatActivity{
    TextView responseText;
    RequestInterface apiInterface;
    ArrayList<String> restaurantIDList;
    private List<R_Details> R_List = new ArrayList<>();
    private RecyclerView recyclerView;
    private RDataAdapter mAdapter;

   /* private ArrayList<AllReview> reviewData;
    private ArrayList<Photo> photoData;*/
   /* private String reviewData;
    private String photoData;*/
   // private RestaurantDataAdapters adapter;
    private RestaurantList restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        responseText = (TextView) findViewById(R.id.json);

        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        mAdapter = new RDataAdapter(getApplicationContext(), R_List);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        loadRestaurantListJSON();


    }

    private void loadRestaurantListJSON() {
        apiInterface = APIClient.getClient().create(RequestInterface.class);

        Call<RestaurantList> call = apiInterface.getRestaurantList("20.358824","85.833266");
        call.enqueue(new Callback<RestaurantList>() {
            @Override
            public void onResponse(Call<RestaurantList> call, Response<RestaurantList> response) {

                restaurantList = response.body();
                Log.d("success", "done");

                Log.d("popul",restaurantList.getNearbyRestaurants().get(0).getRestaurant().getId());
                restaurantIDList = new ArrayList<String>();
                for(int i=0; i<5; i++) {
                    restaurantIDList.add(restaurantList.getNearbyRestaurants().get(i).getRestaurant().getId());

                    R_Details restModel = new R_Details(restaurantList.getNearbyRestaurants().get(i).getRestaurant().getName(),
                            restaurantList.getNearbyRestaurants().get(i).getRestaurant().getFeaturedImage(),
                            restaurantList.getNearbyRestaurants().get(i).getRestaurant().getCuisines());
                    R_List.add(restModel);

                    mAdapter.notifyDataSetChanged();
                    Log.d("done", "done");
                }

                System.out.println(Arrays.toString(restaurantIDList.toArray()));
               // prepareData();

            }

            @Override
            public void onFailure(Call<RestaurantList> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void prepareData() {
        R_Details restModel = new R_Details("Mad Max: Fury Road", "Action & Adventure", "2015");
        R_List.add(restModel);
        restModel = new R_Details("Mad Max: Fury Road", "Action & Adventure", "2015");
        R_List.add(restModel);

        mAdapter.notifyDataSetChanged();
    }
}
