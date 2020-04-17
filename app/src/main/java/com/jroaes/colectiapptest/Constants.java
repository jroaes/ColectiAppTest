package com.jroaes.colectiapptest;

import com.google.android.gms.maps.model.LatLng;

public class Constants {

    /* Services URL*/
    public static final String BASE_URL = "http://ms.colectiapp.cl:7080/";
    public static final String URL_DATA = "dummy/data";

    /*Maps center*/
    public static final LatLng INITIAL_POSITION = new LatLng(-33.416889, -70.606705);
    public static final Float INITIAL_ZOOM = 12.0f;

    /*SharedPreferencesKey*/
    public static final String SHARED_PREFERENCE_NAME = "ColectiAppTest";

    /*Splash duration*/
    public static final Integer SPLASH_DURATION = 2500;

    /*Generic Errors*/
    public static final String SERVER_ERROR = "Ha ocurrido un problema al obtener la información.";
    public static final String NO_INTERNET_ERROR = "No hemos podido obtener la información necesario, revisa tu conexión a internet.";
}
