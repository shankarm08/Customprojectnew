package com.myapp.shankar.weddingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;     //defining google map

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
       // float zoomLevel = 12.0f; //This goes up to 21

        // Add a marker in AGN wedding hall and move the camera
        LatLng latLng = new LatLng(12.889308, 77.597096);  //getting the lattitude and longitude of the location
        mMap.addMarker(new MarkerOptions().position(latLng).title("Welcome to AGN Kalyana Mantapa")); //setting the title
        mMap.animateCamera( CameraUpdateFactory.newLatLngZoom( latLng,19 ),5000,null);
      //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bangalore, zoomLevel));

    }
}
