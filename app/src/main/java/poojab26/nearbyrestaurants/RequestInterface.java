package poojab26.nearbyrestaurants;

import poojab26.nearbyrestaurants.Model.RestaurantList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by pblead26 on 18-Apr-17.
 */

public interface RequestInterface {
    @Headers("user_key: c031832bac8def9a5efadcb27718dfeb")
    @GET("geocode")
    Call<RestaurantList> getRestaurantList(@Query("lat")String lat, @Query("lon")String lon);
}
