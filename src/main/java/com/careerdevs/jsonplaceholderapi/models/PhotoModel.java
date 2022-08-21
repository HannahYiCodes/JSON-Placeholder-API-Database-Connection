package com.careerdevs.jsonplaceholderapi.models;

public class PhotoModel {
//    {
//        "albumId": 1,
//            "id": 1,
//            "title": "accusamus beatae ad facilis cum similique qui sunt",
//            "url": "https://via.placeholder.com/600/92c952",
//            "thumbnailUrl": "https://via.placeholder.com/150/92c952"
//    },

    public int albumId;
    public int id;
    public String title;
    public String url;
    public String thumbnailUrl;

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}

