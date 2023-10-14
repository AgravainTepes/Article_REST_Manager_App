package com.agravain.spring.springboot.rest.app.Exceptions.GlobalExceptionsHandler;

import com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions.ArticleIncorrectAuthor;
import com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions.ArticleIncorrectContent;
import com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions.ArticleIncorrectData;
import com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions.NoSuchArticleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ArticleIncorrectData> handleException(ArticleIncorrectAuthor exception) {
        ArticleIncorrectData data = new ArticleIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ArticleIncorrectData> handleException(ArticleIncorrectContent exception) {
        ArticleIncorrectData data = new ArticleIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ArticleIncorrectData> handleException(NoSuchArticleException exception) {
        ArticleIncorrectData data = new ArticleIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }


}
