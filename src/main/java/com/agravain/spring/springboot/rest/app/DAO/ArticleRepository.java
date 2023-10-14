package com.agravain.spring.springboot.rest.app.DAO;

import com.agravain.spring.springboot.rest.app.Entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity,Integer> {
}
