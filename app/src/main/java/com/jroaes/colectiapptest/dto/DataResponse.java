package com.jroaes.colectiapptest.dto;

public class DataResponse {

    private String name;
    private Double lat;
    private Double lng;
    private String description;

    public DataResponse(String name, Double lat, Double lng, String descrition) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.description = descrition;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
