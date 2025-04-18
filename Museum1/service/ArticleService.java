package com.museum.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import com.museum.dao.ArticleDao;
import com.museum.entity.Article;
import com.museum.entity.Category;
import com.museum.exception.ResourceAlreadyExistException;
import com.museum.exception.ResourceNotFoundArticle;

public class ArticleService {
	
	private ArticleDao articleDao;
	
	public ArticleService() throws SQLException {
		articleDao = new ArticleDao();
	}
	
	public void addArticle(String name, Category category, LocalDate date, String creatorName) throws SQLException {
		
		Optional<Article> existingArticle = articleDao.findAll().stream().filter(article -> article.getName().equalsIgnoreCase(name)).findFirst();
		
		if(existingArticle.isEmpty()) {	
		Article newArticle = new Article(null, name, category, date, creatorName);
		boolean status = articleDao.save(newArticle);
		if(status) {
			System.out.println("Article added successfully..!!!");
		}
		else {
			System.out.println("Article failed to add..!!!");
		}
		
		}else {
			throw new ResourceAlreadyExistException("Article already exist with same name:"+name);
		}
	}
	public void displayAllArticles() throws SQLException {
		articleDao.findAll().stream().forEach(article -> System.out.println(article));
		
	}
	public void displayArticleDetails(Integer id) throws SQLException {
		Article foundArticle = articleDao.findById(id);
		if(foundArticle != null) 
			System.out.println(foundArticle);
	
		else
			throw new ResourceNotFoundArticle("Article not found of id:"+id);
	}
}
