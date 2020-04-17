package com.jroaes.colectiapptest.ui.map;

import com.jroaes.colectiapptest.dto.DataResponse;

import java.util.ArrayList;

public class MapsPresenter implements MapsInterface.Presenter{

    private static MapsActivity view;
    private static MapsModel model;

    private ArrayList<DataResponse> dataMarkersList;

    public MapsPresenter(MapsActivity view){
        this.view = view;
        this.model = new MapsModel(this);
    }

    @Override
    public void initMarkers() {
        model.getMarkers();
    }

    @Override
    public void setMarkers(ArrayList<DataResponse> dataMarkersList) {
        this.dataMarkersList = dataMarkersList;
    }

    @Override
    public void serverError(String error) {

    }
}
