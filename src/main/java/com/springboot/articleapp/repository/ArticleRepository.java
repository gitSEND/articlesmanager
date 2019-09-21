package com.springboot.articleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.articleapp.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

}
