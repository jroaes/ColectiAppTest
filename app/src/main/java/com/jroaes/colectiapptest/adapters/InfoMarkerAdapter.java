package com.jroaes.colectiapptest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.jroaes.colectiapptest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoMarkerAdapter implements GoogleMap.InfoWindowAdapter {

    @BindView(R.id.info_window_name)
    TextView nameMarker;

    @BindView(R.id.info_window_description)
    TextView descriptionMarker;

    private final String TAG = getClass().getName();
    private LayoutInflater inflater;

    public InfoMarkerAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View v = inflater.inflate(R.layout.info_window_marker, null);
        ButterKnife.bind(this, v);

        String[] aux = marker.getTitle().split("&");

        String name = aux[0];
        String description = aux[1];

        nameMarker.setText(name);
        descriptionMarker.setText(description);
        return v;
    }
}
