package com.example.aaaa;

import android.content.Context;
import android.content.Intent;

public class Studio {

    static final String REVIEWS_KEY = "reviews";
    static final String IMAGE_KEY = "image";
    static final String DESC_KEY = "caption";
    static final String NAME_KEY = "name";
    static final String INSTAP_KEY = "instagramp";
    static final String INSTAN_KEY = "instagramn";
    static final String LAT_KEY = "lat";
    static final String LON_KEY = "lon";
    static final String ADDR_KEY = "addr";

    private final String name;
    private final Integer image1;
    private final Integer image2;
    private final String description;
    private final String reviews;
    private final String instagramProfile;
    private final String instagramName;
    private final Double latitude;
    private final Double longitude;
    private final String address;


    public Studio(String name, Integer image1, Integer image2, String description, String reviews, String instagramProfile, String instagramName, Double latitude, Double longitude, String address) {
        this.name = name;
        this.image1 = image1;
        this.image2 = image2;
        this.description = description;
        this.reviews = reviews;
        this.instagramProfile = instagramProfile;
        this.instagramName=instagramName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public Integer getImage1() {
        return image1;
    }

    public Integer getImage2() {
        return image2;
    }

    public String getDescription() {
        return description;
    }

    public String getReviews() {
        return reviews;
    }

    public String getInstagramProfile() {
        return instagramProfile;
    }

    public String getInstagramName() {
        return instagramName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    static Intent starter(Context context, Studio studio) {
        Intent detailIntent = new Intent(context, DetailsActivity.class);
        detailIntent.putExtra(NAME_KEY, studio.getName());
        detailIntent.putExtra(REVIEWS_KEY, studio.getReviews());
        detailIntent.putExtra(IMAGE_KEY, studio.getImage2());
        detailIntent.putExtra(DESC_KEY, studio.getDescription());
        detailIntent.putExtra(INSTAP_KEY, studio.getInstagramProfile());
        detailIntent.putExtra(INSTAN_KEY, studio.getInstagramName());
        detailIntent.putExtra(LAT_KEY, studio.getLatitude());
        detailIntent.putExtra(LON_KEY, studio.getLongitude());
        detailIntent.putExtra(ADDR_KEY, studio.getAddress());
        return detailIntent;
    }
}