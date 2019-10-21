package com.monitoring.springMonitoring.Enums;

public enum ApiResponseEnums {
    API_RESPONSE_FAILED(0,"failed"),
    API_RESPONSE_SUCCESS(1,"Success");

    private int code;
    private String message;

    ApiResponseEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
