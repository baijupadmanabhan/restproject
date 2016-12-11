package com.rest.company;

//import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;


@Path("/companyService")

public class CompanyResource {
	
   private ComDao comdao;
   
   public ComDao getComdao() {
	return comdao;
   }

	public void setComdao(ComDao comdao) {
		this.comdao = comdao;
	}

	@GET
	   @Path("/users")
	   @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//		@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	   public List<Company> getUsers(){
		ComDao comDao = new ComDao();
		List<Company> listcom=comDao.calldb();
	      return listcom;
	   }
	
	@GET
	   @Path("/users/{companyId}")
	   @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//		@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	   public CompanyDetail getCompanyDetails(@PathParam("companyId") String companyId){
//		String comapnyId = "100";
		ComDao comDao = new ComDao();
		CompanyDetail companyDetail=comDao.calldbToGetDetails(companyId);
	      return companyDetail;
	}

}
