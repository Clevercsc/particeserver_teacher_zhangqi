package com.cloudage.membercenter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.cloudage.membercenter.entity.Likes;
@Repository
public interface ILikesRepository extends PagingAndSortingRepository<Likes, Likes.Key> {

	@Query("select count(*) from Likes likes where likes.id.article.id = :articleId")
	int likeCountsOfArticle(int articleId);

	@Query("select count(*) from Likes likes where likes.id.user.id = :authorId and likes.id.article.id = :articleId")
	boolean checkLikesExsists(int authorId, int articleId);
	  
}
