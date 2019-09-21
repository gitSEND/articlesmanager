package com.springboot.articleapp.service;

import java.util.List;

import com.springboot.articleapp.model.Article;

public interface ArticleService {

	List<Article> getAllArticles();

	Article createArticle(Article article);

	Article updateArticle(Long id, Article articleDetails);

	void deleteArticle(Long id);

	Article findById(Long id);
}
