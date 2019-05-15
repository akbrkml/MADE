package com.example.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Catalog implements Parcelable {

    private int poster;
    private String title;
    private String date;
    private String desc;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.desc);
    }

    public Catalog() {
    }

    private Catalog(Parcel in) {
        this.poster = in.readInt();
        this.title = in.readString();
        this.date = in.readString();
        this.desc = in.readString();
    }

    public static final Creator<Catalog> CREATOR = new Creator<Catalog>() {
        @Override
        public Catalog createFromParcel(Parcel source) {
            return new Catalog(source);
        }

        @Override
        public Catalog[] newArray(int size) {
            return new Catalog[size];
        }
    };
}
