package com.example.model;

import lombok.*;

/**
 * Created by Anya.Grinberg on 3/23/2016.
 */

public class Lesson {
    private String id;
    private String title;

    public Lesson(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Lesson() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
