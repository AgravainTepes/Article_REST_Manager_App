package com.agravain.spring.springboot.rest.app.Controller;

import com.agravain.spring.springboot.rest.app.Entity.ArticleEntity;
import com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions.ArticleIncorrectAuthorException;
import com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions.ArticleIncorrectContentException;
import com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions.NoSuchArticleException;
import com.agravain.spring.springboot.rest.app.Service.ArticleServiseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private ArticleServiseImpl articleServise;


    @GetMapping("/articles")
    public ResponseEntity<List<ArticleEntity>> showAllArticles() {
        List<ArticleEntity> articleEntities = articleServise.getAllArticles();
        if (articleEntities.isEmpty())
            throw new NoSuchArticleException
                    ("The storage is empty. Please add at least one article!");
        return new ResponseEntity<>(articleEntities, HttpStatus.OK);
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleEntity> addNewArticle(
            @RequestBody ArticleEntity article) {
        if (article.getAuthor().isEmpty())
            throw new ArticleIncorrectAuthorException
                    ("the \"author\" field should not be empty!");
        if (article.getContent().isEmpty())
            throw new ArticleIncorrectContentException
                    ("the \"author\" field should not be empty!");
        article.setCreateDate(LocalDateTime.now());
        article.setUpdateDate(LocalDateTime.now());
        articleServise.saveArticle(article);
        return new ResponseEntity<>(article, HttpStatus.OK);

    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleEntity> getArticleByID(@PathVariable int id) {
        Optional<ArticleEntity> article = articleServise.getArticleByID(id);
        if (article.isPresent())
            return new ResponseEntity<>(article.get(), HttpStatus.OK);
        throw new NoSuchArticleException
                ("There is no article with id " + id + " in the database!");
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleEntity> updateArticleByID(
            @PathVariable int id, @RequestBody ArticleEntity article) {
        Optional<ArticleEntity> dataBaseArticle =
                articleServise.getArticleByID(id);
        if (dataBaseArticle.isPresent()) {
            article.setId(id);
            article.setCreateDate(dataBaseArticle.get().getCreateDate());
            article.setUpdateDate(LocalDateTime.now());
            articleServise.saveArticle(article);
            return new ResponseEntity<>(article, HttpStatus.OK);
        }
        if (article.getAuthor().isEmpty())
            throw new ArticleIncorrectAuthorException
                    ("the \"author\" field should not be empty!");
        if (article.getContent().isEmpty())
            throw new ArticleIncorrectContentException
                    ("the \"author\" field should not be empty!");
        throw new NoSuchArticleException
                ("There is no article with id " + id + " in the database!");
    }


    @PatchMapping("/articles/{id}")
    public ResponseEntity<ArticleEntity> partialUpdateArticleByID(
            @PathVariable int id, @RequestBody ArticleEntity article) {
        Optional<ArticleEntity> dataBaseArticle = articleServise.getArticleByID(id);
        if (!dataBaseArticle.isPresent())
            throw new NoSuchArticleException(
                    "There is no article with id " + id + " in the database!");
        if (article.getAuthor().isEmpty() && article.getContent().isEmpty())
            throw new ArticleIncorrectAuthorException(
                    "the \"author\" or \" content\" field should not be empty!");
        article.setId(id);
        article.setCreateDate(dataBaseArticle.get().getCreateDate());
        article.setUpdateDate(LocalDateTime.now());
        articleServise.saveArticle(article);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }


    @DeleteMapping("/articles/{id}")
    public ResponseEntity<String> deleteArticleByID(@PathVariable int id) {
        String message = "ok";
        Optional<ArticleEntity> dataBaseArticle = articleServise.getArticleByID(id);
        if (!dataBaseArticle.isPresent())
            throw new NoSuchArticleException(
                    "There is no article with id " + id + " in the database!");
        articleServise.deleteArticleByID(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}


