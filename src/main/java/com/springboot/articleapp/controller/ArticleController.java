package com.springboot.articleapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping("/articles")
	public ModelAndView getAllArticles() {
		List<Article> articles = articleService.getAllArticles();
		ModelAndView mav = new ModelAndView(ARTICLE_PAGE_VIEW);
		mav.addObject("articles", articles);
		return mav;
	}

	@GetMapping("/article/new")
	public String newArticles(Model model) {
		model.addAttribute("article", new Article());
		return ARTICLE_ADD_FORM_VIEW;
	}

	@PostMapping("/article/create")
	public String createArticle(@Valid Article article, BindingResult result,RedirectAttributes attr ,Model model) {
		if (result.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult", result);
			attr.addFlashAttribute("article",article);
			return "redirect:/article/new";
		}
		Article newArticle = articleService.createArticle(article);
		model.addAttribute("article", newArticle.getArticleId());
		return "redirect:/article/" + newArticle.getArticleId();
	}

	@GetMapping("article/{id}")
	public String getArticleById(@PathVariable(value = "id") Long articleId, Model model) {
		model.addAttribute("article", articleService.findById(articleId));
		return ARTICLE_VIEW;
	}

}
