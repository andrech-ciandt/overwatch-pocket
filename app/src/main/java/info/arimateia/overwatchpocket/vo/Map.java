package info.arimateia.overwatchpocket.vo;

/**
 * Created by felipets on 7/24/17.
 */

public class Map {

    private int id;
    private String name;
    private String location;
    private Event event;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Photo getPictures() {
        return pictures;
    }

    public void setPictures(Photo pictures) {
        this.pictures = pictures;
    }
}
