package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloudage.membercenter.entity.Article;
import com.cloudage.membercenter.entity.Likes;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.ILikesRepository;
import com.cloudage.membercenter.entity.Likes.Key;

public class DefaultLikesService implements ILikesService{

	@Autowired
	ILikesRepository likesRepo;
	@Override
	public void addLike(User user, Article article) {
		Likes.Key key = new Key();
		key.setUser(user);
		key.setArticle(article);
		
		Likes lk = new Likes();
		lk.setId(key);
		likesRepo.save(lk);
	}

	@Override
	public void removeLike(User user, Article article) {
		Likes.Key key = new Key();
		 		key.setUser(user);
		 		key.setArticle(article);
		 		
		 		likesRepo.delete(key);
		
	}

	@Override
	public int countLikes(int articleId) {
		return likesRepo.likeCountsOfArticle(articleId);
	}
	@Override
	 	public boolean checkLiked(int userId, int articleId) {
	 		return likesRepo.checkLikesExsists(userId, articleId);
	 	}

}
