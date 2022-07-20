package model;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Response {
    private String statusCode;
    private String message;
    private HashMap<String, Object> parameters = new HashMap<>();
    private User user;
    private ArrayList<String> notifications = new ArrayList<>();

    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, Object> parameters) {
        this.parameters = parameters;
    }

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

    public static Response fromJson(String json) {
        return new Gson().fromJson(json, Response.class);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<String> notifications) {
        this.notifications = notifications;
    }
}
