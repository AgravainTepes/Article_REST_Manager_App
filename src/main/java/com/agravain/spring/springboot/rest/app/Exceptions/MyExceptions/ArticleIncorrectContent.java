package com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions;

public class ArticleIncorrectContent extends RuntimeException {
    public ArticleIncorrectContent(String message) {
        super(message);
    }
}
