package poojab26.nearbyrestaurants.Model;

/**
 * Created by pblead26 on 21-Apr-17.
 */

public class GPSLocation {



    private  String lat, lon;
    public GPSLocation() {

    }

    public GPSLocation(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
