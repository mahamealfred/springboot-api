package com.example.backendapi.dto;

public class ApiResponse<T> {
    private int responseCode;
    private String responseDescription;
    private T data;

    public ApiResponse(int responseCode, String responseDescription, T data) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.data = data;
    }

    // Getters and Setters

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
