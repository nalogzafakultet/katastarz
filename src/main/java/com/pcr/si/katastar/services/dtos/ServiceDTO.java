package com.pcr.si.katastar.services.dtos;

import java.util.ArrayList;
import java.util.List;

public class ServiceDTO {
    private String name;
    private String url;
    private List<EndPointDTO> endpoints = new ArrayList<>();
    private List<String> allow = new ArrayList<>();

    public ServiceDTO() {
    }

    public ServiceDTO(String name, String url, List<EndPointDTO> endpoints, List<String> allow) {
        this.name = name;
        this.url = url;
        this.endpoints = endpoints;
        this.allow = allow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<EndPointDTO> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<EndPointDTO> endpoints) {
        this.endpoints = endpoints;
    }

    public List<String> getAllow() {
        return allow;
    }

    public void setAllow(List<String> allow) {
        this.allow = allow;
    }
}
