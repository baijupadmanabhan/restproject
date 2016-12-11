package com.rest.company;

import java.io.Serializable;

//import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="company")
public class CompanyDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String companySite;
	private String companyId;
	private String companyDesc;
	public String getCompanySite() {
		return companySite;
	}
	public void setCompanySite(String companySite) {
		this.companySite = companySite;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyDesc() {
		return companyDesc;
	}
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}
	public CompanyDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyDetail(String companySite, String companyId, String companyDesc) {
		super();
		this.companySite = companySite;
		this.companyId = companyId;
		this.companyDesc = companyDesc;
	}
	
	
	
}
