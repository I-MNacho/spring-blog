package com.codeup.springblog.controllers.models;

import javax.persistence.*;

@Entity                                                         //allows us to create database and table
@Table(name = "ads")
public class Ad {

    @Id                                                         //this sets the Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //this auto increments the id
    private long id;

    @Column(nullable = true, length = 150, unique = true)       //another way to give columns properties
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")                 //columnDefinition allows us to set what we want for that column
    private String description;


    public Ad(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
