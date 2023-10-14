package com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions;

public class ArticleIncorrectContentException extends RuntimeException {
    public ArticleIncorrectContentException(String message) {
        super(message);
    }
}
