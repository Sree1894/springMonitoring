package com.monitoring.springMonitoring.PayLoad;

public class ApiResponse {

    private int code;
    private Boolean success;
    private String message;
    private Object responseObject;

    public ApiResponse(int code, Boolean success, String message, Object responseObject) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.responseObject = responseObject;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "code=" + code +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", responseObject=" + responseObject +
                '}';
    }
}
