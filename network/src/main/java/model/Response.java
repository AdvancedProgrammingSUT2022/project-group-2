package model;

import com.google.gson.*;

public class Response {
    private String statusCode;
    private String message;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toJson(Response response) {
        return new Gson().toJson(response);
    }
}
