package com.springboot.articleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.articleapp.model.Article;
import com.springboot.articleapp.service.ArticleService;

@Controller
public class ArticleController {

	// view templates
	protected static final String ARTICLE_VIEW = "articles/showArticle"; // view template for single article
	protected static final String ARTICLE_ADD_FORM_VIEW = "articles/newArticle"; // form for new article
	protected static final String ARTICLE_EDIT_FORM_VIEW = "articles/editArticle"; // form for editing an article

	protected static final String ARTICLE_PAGE_VIEW = "articles/allArticles"; // list with pagination

	protected static final String INDEX_VIEW = "index"; // articles with pagination

	@Autowired
	private ArticleService articleService;

	@GetMapping({ "/", "/index" })
	public ModelAndView getIndex() {
		List<Article> articles = articleService.getAllArticles();
		ModelAndView mav = new ModelAndView(INDEX_VIEW);
		mav.addObject("articles", articles);
		return mav;
	}

}
