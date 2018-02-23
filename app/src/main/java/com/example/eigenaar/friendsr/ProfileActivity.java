package com.example.eigenaar.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        // get info from main activity
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // get places
        ImageView photo = findViewById(R.id.photoView);
        TextView name = findViewById(R.id.nameView);
        TextView bio = findViewById(R.id.bioView);

        // put the right values in it
        photo.setImageDrawable(getDrawable(retrievedFriend.getDrawableID()));
        name.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());

        // attach a listener on the rating bar
        ratingBar.setOnRatingBarChangeListener(new RatingBarListener());

        // load information from before
        loadFromSharedPrefs();

    }

    // listen for changes in the rating bar and save the changes
    private class RatingBarListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            saveToSharedPrefs(v);
        }
    }

    // function to save the ratings for each friend
    public void saveToSharedPrefs(float aRating){
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        editor.putFloat(retrievedFriend.getName(), aRating);
        editor.commit();
    }

    // function to load the ratings of each friend
    public void  loadFromSharedPrefs(){
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

        // get the stored rating and if there is no rating than this friend still has rating 0
        float ratingRestored  = prefs.getFloat(retrievedFriend.getName(), 0);
        ratingBar.setRating(ratingRestored);
    }
}
