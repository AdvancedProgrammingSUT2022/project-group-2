package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import enums.Colors;
import model.*;

import java.io.FileWriter;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersController {
    //arraylist of registered users;
    private ArrayList<User> users;
    private HashMap<String , Boolean> availableColors = new HashMap<>();

    public UsersController() {
        users = new ArrayList<>();
        availableColors.put("white" , true);
        availableColors.put("red" , true);
        availableColors.put("green" , true);
        availableColors.put("yellow" , true);
        availableColors.put("blue" , true);
        availableColors.put("purple" , true);
        availableColors.put("cyan" , true);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    //add user
    public void addUser(User user) {
        users.add(user);
    }
    //if same username exists among the users or not
    public boolean sameUsernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return true;
        }
        return false;
    }
    //if same nickname exists among the users or not
    public boolean sameNicknameExists(String nickname) {
        for (User user : users) {
            if (user.getNickname().equals(nickname))
                return false;
        }
        return true;
    }
    //get user by username
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }
    // read the information of users from .json file
    public ArrayList<User> readFromJson() {
        try {
            String usersJson = new String(Files.readAllBytes(Paths.get("usersInformation.json")));
            ArrayList<User> usersFromJson = new Gson().fromJson(usersJson, new TypeToken<List<User>>(){}.getType());
            if (usersFromJson != null)
                return usersFromJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // write the information of users to .json file
    public void writeToJson() {
        try {
            FileWriter WriterToJson = new FileWriter("usersInformation.json");
            if (users.size() > 0)
                WriterToJson.write(new Gson().toJson(users));
            WriterToJson.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // read the graph and prerequisites
    public int[][] readFromJsonGraph() {
        try {
            String all = new String(Files.readAllBytes(Paths.get("TechFile/graph.json")));
            return new Gson().fromJson(all, int[][].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // read all technologies
    public ArrayList<Technology> readFromJsonTech() {
        try {
            String all = new String(Files.readAllBytes(Paths.get("TechFile/tech.json")));
            return new Gson().fromJson(all, new TypeToken<List<Technology>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // write graph to json
    public void writeToJson(int[][] graph) {
        try {
            FileWriter fileWriter = new FileWriter("TechFile/graph.json");
            fileWriter.write(new Gson().toJson(graph));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // write technologies to json
    public void writeToJson(ArrayList<Technology> technologies) {
        try {
            FileWriter fileWriter = new FileWriter("TechFile/tech.json");
            fileWriter.write(new Gson().toJson(technologies));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    public void addBasicImprovements(ArrayList<User> players) {
        ArrayList<Improvement> improvements;
        for (User player : players) {
            improvements = new ArrayList<>();
            //improvements.add(new Improvement("Farm", 0, 1, 0, 5));
            player.setImprovements(improvements);
        }
    }
     */

    public void printRemainColors(){
        AtomicInteger number = new AtomicInteger(1);
        availableColors.forEach((key , value) -> {
            if (value){
                String color = new ColorsController().getColorOfString(key);
                System.out.println(number + "- " + color + key + Colors.RESET);
                number.getAndIncrement();
            }
        });
    }

    public Boolean isSelectedColorValid(String color){
        if (!availableColors.containsKey(color)){
            System.out.println("The selected color is not an available color");
            return false;
        } else if (!availableColors.get(color)){
            System.out.println("The selected color is taken by another user");
            return false;
        } else return true;
    }

    public void setUserColor(String color , User user){
        user.setColor(color);
        availableColors.replace(color , false);
    }
}
