package com.cloudage.membercenter.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.DateRecord;
@Entity
public class Comment extends DateRecord {

	String text;
	User author;
	Article article;

	public String getText() {
		return text;
	}

	@ManyToOne(optional = false)
	public User getAuthor() {
		return author;
	}

	@ManyToOne(optional = false)
	public Article getArticle() {
		return article;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}
