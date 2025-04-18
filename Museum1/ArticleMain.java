package com.museum;

import java.sql.SQLException; 
import java.time.LocalDate;
import java.util.Scanner;

import com.museum.entity.Category;
import com.museum.exception.ResourceAlreadyExistException;
import com.museum.service.ArticleService;

public class ArticleMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArticleService service= null;
		
		try {
		 service = new ArticleService();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		boolean exit = true;
		while(exit) {
			System.out.println("+++++ Menu +++++"
					+ "\n1.Add Article."
					+ "\n2.Display All Articles."
					+ "\n3.Display Details of Article."
					+ "\n0.Exit.");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				try {
					System.out.println("Enter article name, category(PAINTING, SCULPTURE, ARTIFACT), created date, creator name:" );
					String name = sc.next();
					Category category = Category.valueOf(sc.next());
					LocalDate date = LocalDate.parse(sc.next());
					String creatorName = sc.next();
					service.addArticle(name, category, date, creatorName);
				} catch (SQLException | ResourceAlreadyExistException e) {
					System.out.println();
				}
				
				break;
			}
			case 2:{
				try {
					service.displayAllArticles();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			case 3:{
				try {
					System.out.println("Enter article id: ");
					service.displayArticleDetails(sc.nextInt());
				} catch (SQLException | ResourceAlreadyExistException e) {
					System.out.println(e.getMessage());
				}
				
				
				break;
			}
			case 0:{
				
				exit=false;
				System.out.println("Thank You");
				
				break;
			}
			}
			
		}
	}
}
