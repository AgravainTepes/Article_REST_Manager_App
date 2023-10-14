package com.agravain.spring.springboot.rest.app.Service;

import com.agravain.spring.springboot.rest.app.DAO.ArticleRepository;
import com.agravain.spring.springboot.rest.app.Entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiseImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleEntity> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void saveArticle(ArticleEntity article) {
        articleRepository.save(article);
    }

    @Override
    public Optional<ArticleEntity> getArticleByID(int id) {

        Optional<ArticleEntity> optional = articleRepository.findById(id);

        return optional;
    }

    @Override
    public void deleteArticleByID(int id) {
        articleRepository.deleteById(id);
    }

}
