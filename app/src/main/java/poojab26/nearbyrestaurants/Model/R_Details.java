package poojab26.nearbyrestaurants.Model;

/**
 * Created by pblead26 on 21-Apr-17.
 */

public class R_Details {
    private String RName, RPhoto, RCuisine;

    public R_Details(String RName, String RPhoto, String RCuisine) {
        this.RName = RName;
        this.RPhoto = RPhoto;
        this.RCuisine = RCuisine;
    }

    public R_Details(){}

    public String getRName() {
        return RName;
    }

    public void setRName(String RName) {
        this.RName = RName;
    }

    public String getRPhoto() {
        return RPhoto;
    }

    public void setRPhoto(String RPhoto) {
        this.RPhoto = RPhoto;
    }

    public String getRCuisine() {
        return RCuisine;
    }

    public void setRCuisine(String RCuisine) {
        this.RCuisine = RCuisine;
    }




}
