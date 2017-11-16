package com.hgp_android.coleliga.player;

/**
 * Created by paco on 15/11/17.
 */

public class Player {

    private String name;
    private String nickname;
    private String birthdate;
    private String country;
    private String city;
    private int image;
    private String position;

    public Player(String name, String nickname, String birthdate, String country, String city, int image, String position) {
        this.name = name;
        this.nickname = nickname;
        this.birthdate = birthdate;
        this.country = country;
        this.city = city;
        this.image = image;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

