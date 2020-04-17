package com.jroaes.colectiapptest.ui.map;

import com.jroaes.colectiapptest.dto.DataResponse;

import java.util.ArrayList;

public interface MapsInterface {

    interface View{

    }

    interface Presenter{
        void initMarkers();
        void setMarkers(ArrayList<DataResponse> dataMarkersList);
        void serverError(String error);
    }

    interface Model{
        void getMarkers();
    }
}
