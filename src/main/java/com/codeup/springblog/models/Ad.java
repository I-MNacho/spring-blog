package com.codeup.springblog.models;

import javax.persistence.*;

@Entity                                                         //allows us to create database and table
@Table(name = "ads")
public class Ad {

    @Id                                                         //this sets the Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //this auto increments the id
    private long id;

    @Column(nullable = true, length = 300)       //another way to give columns properties
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")                 //columnDefinition allows us to set what we want for that column
    private String description;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Ad() {
    }

    public Ad(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

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
