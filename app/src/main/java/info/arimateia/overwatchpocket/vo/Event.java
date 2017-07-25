package info.arimateia.overwatchpocket.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by felipets on 7/24/17.
 */

public class Event {

    private int id;
    private String name;
    @SerializedName("star_date")
    private String starDate;
    @SerializedName("end_date")
    private String endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
