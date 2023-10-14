package com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions;

public class ArticleIncorrectAuthorException extends RuntimeException {
    public ArticleIncorrectAuthorException(String message) {
        super(message);
    }
}
