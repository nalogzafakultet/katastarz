package com.pcr.si.katastar.services.dtos;

public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private final String method;

    private HttpMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return this.method;
    }
}
