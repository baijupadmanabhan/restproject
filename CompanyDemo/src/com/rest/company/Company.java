package com.rest.company;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="company")
public class Company implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String companyName;
	private String companyId;
	
	public String getCompanyName() {
		return companyName;
	}

	@XmlElement
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

		public String getCompanyId() {
		return companyId;
	}

	@XmlElement
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public Company(){};
	public Company(String companyName, String companyId) {
		super();
		this.companyName = companyName;
		this.companyId = companyId;
	}
	
}
