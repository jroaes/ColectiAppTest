package com.jroaes.colectiapptest.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jroaes.colectiapptest.R;
import com.jroaes.colectiapptest.adapters.InfoMarkerAdapter;
import com.jroaes.colectiapptest.base.BaseFragmentActivity;

public class MapsActivity extends BaseFragmentActivity implements OnMapReadyCallback {

    private static MapsPresenter presenter;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        presenter = new MapsPresenter(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new InfoMarkerAdapter(LayoutInflater.from(this)));
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in & Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        presenter.initMarkers();
    }
}
