package com.pcr.si.katastar.services.dtos;

public class EndPointDTO {
    private String path;
    private HttpMethod method;
    private String bodySchema;
    private String responseSchema;

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

    public String getBodySchema() {
        return bodySchema;
    }

    public void setBodySchema(String bodySchema) {
        this.bodySchema = bodySchema;
    }

    public String getResponseSchema() {
        return responseSchema;
    }

    public void setResponseSchema(String responseSchema) {
        this.responseSchema = responseSchema;
    }

    public EndPointDTO() {
    }

    public EndPointDTO(String path, HttpMethod method, String bodySchema, String responseSchema) {
        this.path = path;
        this.method = method;
        this.bodySchema = bodySchema;
        this.responseSchema = responseSchema;
    }
}
