package com.Jericho.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jericho.spring.rest.model.CompanyDetail;
import com.Jericho.spring.rest.model.CompanyList;
import com.Jericho.spring.rest.dao.CompanyDao;

@RestController
public class CompanyResource {
	
	@Autowired
	private CompanyDao companyDao;
	
		@RequestMapping("/companylist")
	   public CompanyList getCompanyList(){
		   return companyDao.findListOfCompanies();
	   }
	
		@RequestMapping("/company/{permId}")
		public CompanyDetail getCompanyDetails(@PathVariable("permId") String permId){
		return companyDao.findCompanyDetails(permId);
		}
}
