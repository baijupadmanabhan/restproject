package com.Jericho.spring.rest.model;

import java.io.Serializable;

//@XmlRootElement(name ="company")
public class Company implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String companyId;
	public Company(String companyId, String companyName, String website, String revenueRank, String permId,
			String businessSector, String ticker, String ric/*, String lastUpdate*/) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.website = website;
		this.revenueRank = revenueRank;
		this.permId = permId;
		this.businessSector = businessSector;
		this.ticker = ticker;
		this.ric = ric;
		//this.lastUpdate = lastUpdate;
	}
	public Company(String companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		
	}
	public Company() {
		// TODO Auto-generated constructor stub
	}
	private String companyName;
	private String website;
	private String revenueRank;
	private String permId;
	private String businessSector;
	private String ticker;
	private String ric;
	//private String lastUpdate;
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getRevenueRank() {
		return revenueRank;
	}
	public void setRevenueRank(String revenueRank) {
		this.revenueRank = revenueRank;
	}
	public String getPermId() {
		return permId;
	}
	public void setPermId(String permId) {
		this.permId = permId;
	}
	public String getBusinessSector() {
		return businessSector;
	}
	public void setBusinessSector(String businessSector) {
		this.businessSector = businessSector;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getRic() {
		return ric;
	}
	public void setRic(String ric) {
		this.ric = ric;
	}
	/*public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}*/
	
			
	
	
	
}
