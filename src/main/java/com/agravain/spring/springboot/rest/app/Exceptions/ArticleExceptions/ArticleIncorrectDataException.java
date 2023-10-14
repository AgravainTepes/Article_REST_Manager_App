package com.agravain.spring.springboot.rest.app.Exceptions.ArticleExceptions;

public class ArticleIncorrectDataException {

    private String info;

    public ArticleIncorrectDataException() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
