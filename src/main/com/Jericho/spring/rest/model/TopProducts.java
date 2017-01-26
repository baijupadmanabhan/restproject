package com.Jericho.spring.rest.model;

import java.io.Serializable;

public class TopProducts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String businessUnit;
	private String revenueRank;
	private String currentPeriodRevenue;
	private String priorPeriodRevenue;
	private String productName;
	
	
	public TopProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TopProducts(String businessUnit, String revenueRank, String currentPeriodRevenue, String priorPeriodRevenue,
			String productName) {
		super();
		this.businessUnit = businessUnit;
		this.revenueRank = revenueRank;
		this.currentPeriodRevenue = currentPeriodRevenue;
		this.priorPeriodRevenue = priorPeriodRevenue;
		this.productName = productName;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getRevenueRank() {
		return revenueRank;
	}
	public void setRevenueRank(String revenueRank) {
		this.revenueRank = revenueRank;
	}
	public String getCurrentPeriodRevenue() {
		return currentPeriodRevenue;
	}
	public void setCurrentPeriodRevenue(String currentPeriodRevenue) {
		this.currentPeriodRevenue = currentPeriodRevenue;
	}
	public String getPriorPeriodRevenue() {
		return priorPeriodRevenue;
	}
	public void setPriorPeriodRevenue(String priorPeriodRevenue) {
		this.priorPeriodRevenue = priorPeriodRevenue;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}
