package com.example.eigenaar.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    // the current friends (users)
    String[] names = new String[]{ "Arya", "Cersei", "Daenerys", "Jaime", "Jon", "Jorah", "Margaery",
                                    "Melisandre", "Sansa", "Tyrion", "Priyanka", "Aishwarya",
                                    "Hrithik", "Sidharth"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate and add all the users
        for (String s : names){
            Friend f = new Friend(s, "My name is "+s +".", this.getResources().getIdentifier(
                    s.toLowerCase(), "drawable", getPackageName()));
            friends.add(f);
        }

        GridView friendsView = findViewById(R.id.gridviewFriends);

        // instantiate and attach adapter to GridView
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        friendsView.setAdapter(adapter);

        // connect listener to GridView
        friendsView.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);

            // pass information to next activity
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}


