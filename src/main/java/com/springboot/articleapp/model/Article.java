package com.springboot.articleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "articles")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long articleId;

	@Size(min = 2, max = 100, message = "Titlo debe tener entre 2 a 100 caracteres")
	@Column(name = "title")
	private String title;

	@NotEmpty(message = "Ingresar una categoría")
	@Column(name = "category")
	private String category;

	@NotEmpty(message = "Ingresar un autor")
	@Column(name = "author")
	private String author;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@NotEmpty(message = "Debe ingresar una descripción")
	@Column(name = "description")
	private String description;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@NotEmpty(message = "Debe ingresar un contenido")
	@Column(name = "content")
	private String content;
	
	
	public Article() {

	}

	public Article(String title, String category, String author, String description, String content) {
		super();
		this.title = title;
		this.category = category;
		this.author = author;
		this.description = description;
		this.content = content;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
