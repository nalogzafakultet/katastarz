package com.pcr.si.katastar.services.dtos;

public class EndPointDTO {
    private String path;
    private HttpMethod method;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public EndPointDTO() {
    }

    public EndPointDTO(String path, HttpMethod method) {
        this.path = path;
        this.method = method;
    }
}
