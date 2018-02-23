package com.example.eigenaar.friendsr;

import java.io.Serializable;

/**
 * Class for a user (friend).
 */

public class Friend implements Serializable {

    // properties
    private String name, bio;
    private  int drawableID;
    private float rating;

    // constructor (given)
    public Friend(String aName, String aBio, int aId) {
        name = aName;
        bio = aBio;
        drawableID = aId;
    }

    // add getter functions for all fields
    // (not used for rating but it was a specif exercise so I didn't delete it)
    public String getName(){
        return name;
    }

    public String getBio(){
        return bio;
    }

    public int getDrawableID(){
        return drawableID;
    }

    public float getRating(){
        return rating;
    }

    // add 1 setter function for the rating
    // (not used but it was a specif exercise so I didn't delete it)
    public void setRating(float aRating){
        rating = aRating;
    }
}
