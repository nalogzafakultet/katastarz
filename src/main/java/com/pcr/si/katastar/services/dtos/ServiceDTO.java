package com.pcr.si.katastar.services.dtos;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

public class ServiceDTO {
    private String name;
    private String baseUrl;
    private List<EndPointDTO> endpoints = new ArrayList<>();
    private List<String> allow = new ArrayList<>();

    public ServiceDTO() {
    }

    public ServiceDTO(String name, String baseUrl, List<EndPointDTO> endpoints, List<String> allow) {
        this.name = name;
        this.baseUrl = baseUrl;
        this.endpoints = endpoints;
        this.allow = allow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<EndPointDTO> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<EndPointDTO> endpoints) {
        this.endpoints = endpoints;
    }

    public void addEndpoint(EndPointDTO endpoint) {
        endpoints.add(endpoint);
    }

    public List<String> getAllow() {
        return allow;
    }

    public void setAllow(List<String> allow) {
        this.allow = allow;
    }
}
