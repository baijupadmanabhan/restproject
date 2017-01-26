package com.Jericho.spring.rest.model;

import java.io.Serializable;

public class Revenue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String businessUnit;
	private String currentPeriodRevenue;
	private String priorPeriodRevenue;
	
	
	public Revenue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Revenue(String businessUnit, String currentPeriodRevenue, String priorPeriodRevenue) {
		super();
		this.businessUnit = businessUnit;
		this.currentPeriodRevenue = currentPeriodRevenue;
		this.priorPeriodRevenue = priorPeriodRevenue;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
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
	
	

}
