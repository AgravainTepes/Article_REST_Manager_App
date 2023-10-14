package com.agravain.spring.springboot.rest.app.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "articles")
public class ArticleEntity {

    public ArticleEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "author")
    private String author;
    @Column(name = "content")
    private String content;
    @Column(name = "createDate")
    private LocalDateTime createDate;
    @Column(name = "updateDate")
    private LocalDateTime updateDate;


    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = localDateTimeFormatter(createDate);
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = localDateTimeFormatter(updateDate);
    }

    public LocalDateTime localDateTimeFormatter(LocalDateTime reference) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String middleResult = reference.format(formatter);
        LocalDateTime result = LocalDateTime.parse(middleResult, formatter);
        return result;
    }

}
