package com.jroaes.colectiapptest.ui.map;

import com.google.android.gms.maps.model.LatLng;
import com.jroaes.colectiapptest.dto.DataResponse;

import java.util.ArrayList;

public class MapsPresenter implements MapsInterface.Presenter {

    private static MapsActivity view;
    private static MapsModel model;

    private ArrayList<DataResponse> dataMarkersList;

    public MapsPresenter(MapsActivity view) {
        this.view = view;
        this.model = new MapsModel(this);
    }

    @Override
    public void initMarkers() {
        view.showLoading();
        model.getMarkers();
    }

    @Override
    public void setMarkers(ArrayList<DataResponse> dataMarkersList) {
        if (dataMarkersList != null) {
            this.dataMarkersList = dataMarkersList;
            for (DataResponse dataMarker : dataMarkersList) {
                if (dataMarker != null && dataMarker.getName() != null && dataMarker.getLat() != null && dataMarker.getLng() != null) {
                    LatLng latLng = new LatLng(dataMarker.getLat(), dataMarker.getLng());
                    String title = dataMarker.getName() + "&" + dataMarker.getDescription();
                    view.addMarker(latLng, title);
                }
            }
        }
        view.hideLoading();
    }

    @Override
    public void serverError(String error) {
        view.hideLoading();
        if (error != null && error != "") {
            view.showServerError(error);
        } else {
            view.showServerError(error);
        }
    }
}
