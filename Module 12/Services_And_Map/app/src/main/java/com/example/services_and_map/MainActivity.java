package com.example.services_and_map;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

  // private variable for map though its outdated now.
    private GoogleMap map;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // starting Service.
    startService(new Intent(MainActivity.this, MyService.class));

    // Showing Toast Message.
    Toast.makeText( MainActivity.this, "Enjoy the Music! ", Toast.LENGTH_LONG ).show();

    // Making a map Fragment.
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
  }


  // Calling the MapReady.
  @Override
  public void onMapReady(GoogleMap googleMap) {
     map = googleMap;

     // Location and Cords.
    LatLng LakeChad = new LatLng(13.090994, 14.542955);
    googleMap.addMarker(new MarkerOptions().position(LakeChad).title("Lake Chad"));
    googleMap.moveCamera(CameraUpdateFactory.newLatLng(LakeChad));
  }
}
