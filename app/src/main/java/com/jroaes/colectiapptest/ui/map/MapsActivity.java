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

import static com.jroaes.colectiapptest.Constants.INITIAL_POSITION;
import static com.jroaes.colectiapptest.Constants.INITIAL_ZOOM;

public class MapsActivity extends BaseFragmentActivity implements MapsInterface.View, OnMapReadyCallback {

    private static MapsPresenter presenter;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        presenter = new MapsPresenter(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new InfoMarkerAdapter(LayoutInflater.from(this)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(INITIAL_POSITION, INITIAL_ZOOM));

        presenter.initMarkers();
    }

    @Override
    public void addMarker(LatLng position, String title) {
        mMap.addMarker(new MarkerOptions().position(position).title(title));
    }

    @Override
    public void showServerError(String text) {
        showErrorMessage(text);
    }

    @Override
    public void showLoading() {
        showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog(this);
    }
}
