package com.codecool.coolnote.model;

import java.time.LocalDateTime;

public class Note {
    public String title;
    private String description;
    private final LocalDateTime time;

    private int counter;

//    public Note(String title, String description) {
//        this.title = title;
//        this.description = description;
//        counter = 0;
//    }

    public Note() {
        this.time = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCounter() {
        return counter;
    }

    public void editNote(){
        counter++;
    }

    public String getStringCounter(){
        return " " + counter + " ";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getTime() {
        return time.toString();
    }
}
