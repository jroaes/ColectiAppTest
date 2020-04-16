package com.jroaes.colectiapptest.Network;

import static com.jroaes.colectiapptest.Constants.BASE_URL;

/**
 * Created by Nostrum 2 on 13-02-2018.
 */

public class ApiUtils {

    private ApiUtils() {
    }

    /**
     * Obtiene y crea el cliente Retrofit
     *
     * @return Retorna el cliente.
     */
    public static RetrofitApi obtenerCliente() {
        return ApiClient.getClient(BASE_URL).create(RetrofitApi.class);
    }
}
