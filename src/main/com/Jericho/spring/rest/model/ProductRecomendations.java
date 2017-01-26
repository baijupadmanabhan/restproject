package com.Jericho.spring.rest.model;

import java.io.Serializable;

public class ProductRecomendations implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String businessUnit;
	private String productName;
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductRecomendations(String businessUnit, String productName) {
		super();
		this.businessUnit = businessUnit;
		this.productName = productName;
	}
	public ProductRecomendations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
