package com.example.aaaa;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback, GoogleMap.OnMarkerClickListener {

        private LatLng myLocation;
        private GoogleMap mMap = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);
            SupportMapFragment mMap = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mMap.getMapAsync(this);
        }

        @Override
        public void onMapReady(GoogleMap mMap) {
            this.mMap = mMap;
            mMap.setOnMapLoadedCallback(this);
        }


        @Override
        public void onMapLoaded() {

        }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
