package com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions;

public class NoSuchArticleException extends RuntimeException{

    public NoSuchArticleException(String message) {
        super(message);
    }
}
