package com.jroaes.colectiapptest.ui.map;

import com.jroaes.colectiapptest.requests.DataMarkers;

public class MapsModel implements MapsInterface.Model {

    private static MapsPresenter presenter;

    public MapsModel(MapsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getMarkers() {
        DataMarkers.getInstance().reqState((state, error, dataMarkersList) -> {
            if (state)
                presenter.setMarkers(dataMarkersList);
            else
                presenter.serverError(error);
        });
    }
}
