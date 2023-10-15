package com.agravain.spring.springboot.rest.app.Exceptions.GlobalExceptionsHandler;

import com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions.ArticleIncorrectAuthorException;
import com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions.ArticleIncorrectContentException;
import com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions.ArticleIncorrectDataException;
import com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions.NoSuchArticleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ArticleIncorrectDataException> handleException(
            ArticleIncorrectAuthorException exception) {
        ArticleIncorrectDataException data = new ArticleIncorrectDataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ArticleIncorrectDataException> handleException(
            ArticleIncorrectContentException exception) {
        ArticleIncorrectDataException data = new ArticleIncorrectDataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ArticleIncorrectDataException> handleException(
            NoSuchArticleException exception) {
        ArticleIncorrectDataException data = new ArticleIncorrectDataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }


}
