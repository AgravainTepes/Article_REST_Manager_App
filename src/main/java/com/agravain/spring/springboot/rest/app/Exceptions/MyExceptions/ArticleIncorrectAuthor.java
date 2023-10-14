package com.agravain.spring.springboot.rest.app.Exceptions.MyExceptions;

public class ArticleIncorrectAuthor extends RuntimeException {
    public ArticleIncorrectAuthor(String message) {
        super(message);
    }
}
