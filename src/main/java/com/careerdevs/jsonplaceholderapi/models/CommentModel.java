package com.careerdevs.jsonplaceholderapi.models;

public class CommentModel {
    //    {
//        "postId": 1,
//            "id": 1,
//            "name": "id labore ex et quam laborum",
//            "email": "Eliseo@gardner.biz",
//            "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
//    },
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}