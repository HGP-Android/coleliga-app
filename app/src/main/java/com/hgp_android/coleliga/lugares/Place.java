package com.hgp_android.coleliga.lugares;

/**
 * Created by paco on 19/11/17.
 */

public class Place {

    String name;
    int image;
    String address;
    String schedule;
    String body;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Place(String name, int image, String address, String schedule, String body) {
        this.name = name;
        this.image = image;
        this.address = address;
        this.schedule = schedule;
        this.body = body;
    }
}
