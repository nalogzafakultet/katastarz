package com.pcr.si.katastar.services.dtos;

public class PravniStatusDTO {
    private String pravniStatus;

    public String getPravniStatus() {
        return pravniStatus;
    }

    public void setPravniStatus(String pravniStatus) {
        this.pravniStatus = pravniStatus;
    }

    @Override
    public String toString() {
        return "PravniStatusDTO{" +
                "pravniStatus='" + pravniStatus + '\'' +
                '}';
    }
}
