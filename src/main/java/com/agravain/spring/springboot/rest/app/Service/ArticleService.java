package com.agravain.spring.springboot.rest.app.Service;

import com.agravain.spring.springboot.rest.app.Entity.ArticleEntity;

import java.util.List;

public interface ArticleService {

    public List<ArticleEntity> getAllArticles();

    public void saveArticle(ArticleEntity article);

    public ArticleEntity getArticleByID(int id);

    public void deleteArticleByID(int id);

}
