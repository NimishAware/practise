package com.museum.entity;

import java.time.LocalDate;

public class Article {
	private Integer id;
	private String name;
	private Category category;
	private LocalDate date;
	private String creatorName;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(Integer id, String name, Category category, LocalDate date, String creatorName) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.date = date;
		this.creatorName = creatorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", category=" + category + ", date=" + date + ", creatorName="
				+ creatorName + "]";
	}
	
}
