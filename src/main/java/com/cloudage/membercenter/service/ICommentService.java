package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.cloudage.membercenter.entity.Comment;

public interface ICommentService {
	
	Page<Comment> findCommentsOfArticle(int articleId, int page);//查找文章的评论

	Comment save(Comment comment);

	
	int getCommentCountOfArticle(int articleId);
	Page<Comment> findMyCommentsByAuthorId(int authorId, int page);//我发出评论
	
	Page<Comment> findReceiveCommentsByAuthorId(int authorId, int page);
}
	
