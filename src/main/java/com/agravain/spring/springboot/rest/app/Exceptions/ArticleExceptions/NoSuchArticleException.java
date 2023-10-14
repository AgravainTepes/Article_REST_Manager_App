package com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions;

public class NoSuchArticleException extends RuntimeException{

    public NoSuchArticleException(String message) {
        super(message);
    }
}
