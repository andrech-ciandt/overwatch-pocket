package info.arimateia.overwatchpocket.vo;

/**
 * Created by felipets on 7/18/17.
 */

public class Hero {

    private int id;
    private String name;
    private String description;
    private Photo pictures;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Photo getPictures() {
        return pictures;
    }

    public void setPictures(Photo pictures) {
        this.pictures = pictures;
    }
}
