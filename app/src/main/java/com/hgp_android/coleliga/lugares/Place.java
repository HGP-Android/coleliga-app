package com.hgp_android.coleliga.lugares;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by paco on 19/11/17.
 */
public class Place implements Parcelable {

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

    protected Place(Parcel in) {
        name = in.readString();
        image = in.readInt();
        address = in.readString();
        schedule = in.readString();
        body = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(image);
        dest.writeString(address);
        dest.writeString(schedule);
        dest.writeString(body);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
}