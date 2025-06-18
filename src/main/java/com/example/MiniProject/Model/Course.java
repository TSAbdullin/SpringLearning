package com.example.MiniProject.Model;

public class Course {
    private static long idCounder = 1;

    private long id;
    private String title;
    private String description;
    private String author;
    private int duration;

    public Course() {
        this.id = idCounder++;
    }

    public Course(String title, String description, String author, int duration) {
        this.id = idCounder++;
        this.author = author;
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    //Геттеры и сеттеры

    public long getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }

}
