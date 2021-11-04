package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
public class Doggo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(columnDefinition = "TINYINT(3) UNSIGNED", nullable = false, unique = true)
    private int age;

    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String name;

    @Column(columnDefinition = "CHAR(2) DEFAULT 'XX'")
    private String resideState;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
