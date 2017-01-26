package com.Jericho.spring.rest.model;

import java.io.Serializable;
import java.util.List;

public class CompanyDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Company company;
	private List<Revenue> revenue;
	private List<ProductRecomendations> productRecomendations;
	private List<TopProducts> topProducts;
	
	
	public CompanyDetail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompanyDetail(Company company, List<Revenue> revenue, List<ProductRecomendations> productRecomendations,
			List<TopProducts> topProducts) {
		super();
		this.company = company;
		this.revenue = revenue;
		this.productRecomendations = productRecomendations;
		this.topProducts = topProducts;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public List<Revenue> getRevenue() {
		return revenue;
	}


	public void setRevenue(List<Revenue> revenue) {
		this.revenue = revenue;
	}


	public List<ProductRecomendations> getProductRecomendations() {
		return productRecomendations;
	}


	public void setProductRecomendations(List<ProductRecomendations> productRecomendations) {
		this.productRecomendations = productRecomendations;
	}


	public List<TopProducts> getTopProducts() {
		return topProducts;
	}


	public void setTopProducts(List<TopProducts> topProducts) {
		this.topProducts = topProducts;
	}
	
}
