package com.agravain.spring.springboot.rest.app.Controller;

import com.agravain.spring.springboot.rest.app.Entity.ArticleEntity;
import com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions.ArticleIncorrectAuthor;
import com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions.ArticleIncorrectContent;
import com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions.NoSuchArticleException;
import com.agravain.spring.springboot.rest.app.Service.ArticleServiseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private ArticleServiseImpl articleServise;


    @GetMapping("/articles")
    public ResponseEntity<List<ArticleEntity>> showAllArticles() {
        List<ArticleEntity> articleEntities = articleServise.getAllArticles();
        if (articleEntities.isEmpty())
            throw new NoSuchArticleException("The storage is empty. Please add at least one article!");
        return new ResponseEntity<>(articleEntities, HttpStatus.OK);
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleEntity> addNewArticle(@RequestBody ArticleEntity article) {
        if (article.getAuthor().isEmpty()) {
            throw new ArticleIncorrectAuthor("the \"author\" field should not be empty!");
        } else if (article.getContent().isEmpty()) {
            throw new ArticleIncorrectContent("the \"author\" field should not be empty!");
        } else {
            article.setCreateDate(LocalDateTime.now());
            article.setUpdateDate(LocalDateTime.now());
            articleServise.saveArticle(article);
            return new ResponseEntity<>(article, HttpStatus.OK);
        }
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleEntity> getArticleByID(@PathVariable int id) {
        ArticleEntity article = articleServise.getArticleByID(id);
        if (article == null)
            throw new NoSuchArticleException("There is no article with id " + id + " in the database!");
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleEntity> updateArticleByID(@PathVariable int id, @RequestBody ArticleEntity article) {
        ArticleEntity dataBaseArticle = articleServise.getArticleByID(id);
        if (dataBaseArticle == null) {
            throw new NoSuchArticleException("There is no article with id " + id + " in the database!");
        } else if (article.getAuthor().isEmpty()) {
            throw new ArticleIncorrectAuthor("the \"author\" field should not be empty!");
        } else if (article.getContent().isEmpty()) {
            throw new ArticleIncorrectContent("the \"author\" field should not be empty!");
        } else {
            article.setId(id);
            article.setCreateDate(dataBaseArticle.getCreateDate());
            article.setUpdateDate(LocalDateTime.now());
            articleServise.saveArticle(article);
            return new ResponseEntity<>(article, HttpStatus.OK);
        }
    }

    @PatchMapping("/articles/{id}")
    public ResponseEntity<ArticleEntity> partialUpdateArticleByID(@PathVariable int id, @RequestBody ArticleEntity article) {
        ArticleEntity dataBaseArticle = articleServise.getArticleByID(id);
        if (dataBaseArticle == null) {
            throw new NoSuchArticleException("There is no article with id " + id + " in the database!");
        } else if (article.getAuthor().isEmpty() && article.getContent().isEmpty()) {
            throw new ArticleIncorrectAuthor("the \"author\" or \" content\" field should not be empty!");
        } else {
            article.setId(id);
            article.setCreateDate(dataBaseArticle.getCreateDate());
            article.setUpdateDate(LocalDateTime.now());
            articleServise.saveArticle(article);
            return new ResponseEntity<>(article, HttpStatus.OK);
        }
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<String> deleteArticleByID(@PathVariable int id) {
        String message = "ok";
        ArticleEntity dataBaseArticle = articleServise.getArticleByID(id);
        if (dataBaseArticle == null) {
            throw new NoSuchArticleException("There is no article with id " + id + " in the database!");
        } else {
            articleServise.deleteArticleByID(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

}
