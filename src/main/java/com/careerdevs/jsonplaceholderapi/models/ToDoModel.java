package com.careerdevs.jsonplaceholderapi.models;

public class ToDoModel {
//    {
//        "userId": 1,
//            "id": 1,
//            "title": "delectus aut autem",
//            "completed": false
//    },

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
