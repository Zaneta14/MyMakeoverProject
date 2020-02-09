package com.example.aaaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.os.Bundle;

import java.util.ArrayList;

public class StudiosActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Studio> mStudiosData;
    private StudiosAdapter mAdapter;
    private String pickedCity;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studios);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (mp != null) {
            mp.stop();
            mp.reset();
            mp.release();
        }
        mp = MediaPlayer.create(this,
                R.raw.adaytoremember);
        mp.setLooping(true);
        mp.start();

        Intent intent=getIntent();
        pickedCity=intent.getStringExtra("city");

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mStudiosData = new ArrayList<>();

        mAdapter = new StudiosAdapter(this, mStudiosData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        String[] studioNames;
        String[] descriptions;
        String[] reviews;
        String[] latitudes;
        String[] longitudes;
        String[] instagramProfiles;
        String[] instagramProfileNames;
        TypedArray images1;
        TypedArray images2;
        String[] addresses;
        TextView txt=(TextView) findViewById(R.id.title);
        if (pickedCity.equals("New York")) {
            txt.setText(R.string.msny);
            studioNames=getResources().getStringArray(R.array.newyork_names);
            descriptions=getResources().getStringArray(R.array.newyork_descriptions);
            reviews=getResources().getStringArray(R.array.newyork_reviews);
            latitudes=getResources().getStringArray(R.array.newyork_latitudes);
            longitudes=getResources().getStringArray(R.array.newyork_longitudes);
            instagramProfiles=getResources().getStringArray(R.array.newyork_instagramProfiles);
            instagramProfileNames=getResources().getStringArray(R.array.newyork_instagramNames);
            images1 = getResources().obtainTypedArray(R.array.newyork_image1);
            images2 = getResources().obtainTypedArray(R.array.newyork_image2);
            addresses=getResources().getStringArray(R.array.newyork_locations);
        }
        else if (pickedCity.equals("Miami")) {
            txt.setText(R.string.msm);
            studioNames=getResources().getStringArray(R.array.miami_names);
            descriptions=getResources().getStringArray(R.array.miami_descriptions);
            reviews=getResources().getStringArray(R.array.miami_reviews);
            latitudes=getResources().getStringArray(R.array.miami_latitudes);
            longitudes=getResources().getStringArray(R.array.miami_longitudes);
            instagramProfiles=getResources().getStringArray(R.array.miami_instagramProfiles);
            instagramProfileNames=getResources().getStringArray(R.array.miami_instagramNames);
            images1 = getResources().obtainTypedArray(R.array.miami_image1);
            images2 = getResources().obtainTypedArray(R.array.miami_image2);
            addresses=getResources().getStringArray(R.array.miami_locations);
        }
        else {
            txt.setText(R.string.msc);
            studioNames=getResources().getStringArray(R.array.chicago_names);
            descriptions=getResources().getStringArray(R.array.chicago_descriptions);
            reviews=getResources().getStringArray(R.array.chicago_reviews);
            latitudes=getResources().getStringArray(R.array.chicago_latitudes);
            longitudes=getResources().getStringArray(R.array.chicago_longitudes);
            instagramProfiles=getResources().getStringArray(R.array.chicago_instagramProfiles);
            instagramProfileNames=getResources().getStringArray(R.array.chicago_instagramNames);
            images1 = getResources().obtainTypedArray(R.array.chicago_image1);
            images2 = getResources().obtainTypedArray(R.array.chicago_image2);
            addresses=getResources().getStringArray(R.array.chicago_locations);
        }
        mStudiosData.clear();

        Double[] latitudes1= new Double[latitudes.length];
        Double[] longitudes1= new Double[longitudes.length];
        for (int i=0; i<latitudes.length; i++) {
            latitudes1[i] = Double.valueOf(latitudes[i]);
            longitudes1[i] = Double.valueOf(longitudes[i]);
        }
        for(int i=0; i<studioNames.length; i++){
            mStudiosData.add(new Studio(studioNames[i], images1.getResourceId(i,0),
                    images2.getResourceId(i, 0), descriptions[i], reviews[i], instagramProfiles[i],
                    instagramProfileNames[i], latitudes1[i], longitudes1[i], addresses[i]));
        }
        images1.recycle();
        images2.recycle();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.action_home) {
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }
}