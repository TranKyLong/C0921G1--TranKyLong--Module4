package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String writer;
    private String category;

    @Column(length = 10000)
    private String Content;
    private String postingDay;

    public Blog() {
    }

    public Blog(Integer id, String title, String writer, String category, String content, String postingDay) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.category = category;
        this.Content = content;
        this.postingDay = postingDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPostingDay() {
        return postingDay;
    }

    public void setPostingDay(String postingDay) {
        this.postingDay = postingDay;
    }
}

