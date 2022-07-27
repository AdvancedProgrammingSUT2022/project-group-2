package model;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Request {
    private User user;
    private String action;
    private String message;
    private String menu;
    private HashMap<String, Object> parameters = new HashMap<>();
    private Message messageObject;
    private ArrayList<Message> messageArrayList = new ArrayList<>();

    public ArrayList<Message> getMessageArrayList() {
        return messageArrayList;
    }

    public void setMessageArrayList(ArrayList<Message> messageArrayList) {
        this.messageArrayList = messageArrayList;
    }
    public Message getMessageObject() {
        return messageObject;
    }

    public void setMessageObject(Message messageObject) {
        this.messageObject = messageObject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, Object> parameters) {
        this.parameters = parameters;
    }

    public static Request fromJson(String json) {
        return new Gson().fromJson(json, Request.class);
    }
}
