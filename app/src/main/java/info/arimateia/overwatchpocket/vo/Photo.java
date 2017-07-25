package info.arimateia.overwatchpocket.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by felipets on 7/24/17.
 */

public class Photo {

    private int id;
    private String photo;
    @SerializedName("full_photo")
    private String fullPhoto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFullPhoto() {
        return fullPhoto;
    }

    public void setFullPhoto(String fullPhoto) {
        this.fullPhoto = fullPhoto;
    }
}
