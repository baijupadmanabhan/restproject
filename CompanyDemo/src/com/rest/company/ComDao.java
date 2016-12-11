package com.rest.company;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
//import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;
public class ComDao {
	
	public List<Company> calldb(){
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		List<Company> companies = new ArrayList<Company>();
		try {

/**			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection(
			"jdbc:hsqldb:hsql://localhost/", "SA", "");
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT * FROM Company");
*/
			
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/CompanyDB");
			connection = ds.getConnection();
			
			statement = connection.createStatement();
			String sql = "select * from Company";
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Company company = new Company();
				company.setCompanyName(resultSet.getString("companyname"));
				company.setCompanyId(resultSet.getString("companyId"));
				companies.add(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return companies;
	
	}
	
	public CompanyDetail calldbToGetDetails(String companyId){
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		CompanyDetail companyDetails = new CompanyDetail();
		try {

			
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/CompanyDB");
			connection = ds.getConnection();
			
			statement = connection.createStatement();
			String sql = "select * from companydetails where companyId =" + "'"+ companyId+"'" ;
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				companyDetails.setCompanySite(resultSet.getString("companysite"));
				companyDetails.setCompanyDesc(resultSet.getString("companydesc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return companyDetails;
	
	}

}
