package com.springboot.articleapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.articleapp.model.Article;
import com.springboot.articleapp.repository.ArticleRepository;
import com.springboot.articleapp.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository dao;

	@Override
	public List<Article> getAllArticles() {
		return dao.findAll();
	}

	@Override
	public Article createArticle(Article article) {
		return dao.save(article);
	}

	@Override
	public Article updateArticle(Long id, Article articleDetails) {
		Article article = findById(id);
		article.setTitle(articleDetails.getTitle());
		article.setAuthor(articleDetails.getAuthor());
		article.setDescription(articleDetails.getDescription());
		article.setContent(articleDetails.getContent());
		return dao.save(article);
	}

	@Override
	public void deleteArticle(Long id) {
		dao.delete(findById(id));
	}

	@Override
	public Article findById(Long id) {
		Optional<Article> article = dao.findById(id);
		return article.get();
	}

}
