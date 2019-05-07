package com.pcr.si.katastar.services.dtos;

import java.util.ArrayList;
import java.util.List;

public class ProstornaPretragaReqDTO {

    private double lat;
    private double lng;
    private double radijus;
    private List<String> tipovi = new ArrayList<>();

    public ProstornaPretragaReqDTO() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getRadijus() {
        return radijus;
    }

    public void setRadijus(double radijus) {
        this.radijus = radijus;
    }

    public List<String> getTipovi() {
        return tipovi;
    }

    public void setTipovi(List<String> tipovi) {
        this.tipovi = tipovi;
    }

    @Override
    public String toString() {
        return "ProstornaPretragaReqDTO{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", radijus=" + radijus +
                ", tipovi=" + tipovi +
                '}';
    }
}
