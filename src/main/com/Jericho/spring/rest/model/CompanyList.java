package com.Jericho.spring.rest.model;

import java.io.Serializable;
import java.util.List;

public class CompanyList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Company> companies;
	
	private String lastUpdate;

	public CompanyList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyList(List<Company> companies, String lastUpdate) {
		super();
		this.companies = companies;
		this.lastUpdate = lastUpdate;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	

}
