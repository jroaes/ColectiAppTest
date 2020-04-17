package com.jroaes.colectiapptest.ui.map;

import com.google.android.gms.maps.model.LatLng;
import com.jroaes.colectiapptest.dto.DataResponse;

import java.util.ArrayList;

public interface MapsInterface {

    interface View {
        void addMarker(LatLng position, String title);

        void showServerError(String text);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void initMarkers();

        void setMarkers(ArrayList<DataResponse> dataMarkersList);

        void serverError(String error);
    }

    interface Model {
        void getMarkers();
    }
}
