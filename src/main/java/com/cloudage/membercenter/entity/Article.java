package com.cloudage.membercenter.entity;

import java.util.Date;

import com.cloudage.membercenter.util.BaseEntity;

public class Article extends BaseEntity {
User user;
Date createDate;
Date editDate;
String title;
String text;
@ManyToOne(optional=false)
@JsonIgnore
public User getAuthor() {
	return author;
}

public void setAuthor(User author) {
	this.author = author;
}

@Column(updatable=false)
public Date getCreateDate() {
	return createDate;
}

public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}

public Date getEditDate() {
	return editDate;
}

public void setEditDate(Date editDate) {
	this.editDate = editDate;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

@PreUpdate
void onPreUpdate(){
	editDate = new Date();
}

@PrePersist
void onPrePersist(){
	createDate = new Date();
	editDate = new Date();
}

}
