package com.Jericho.spring.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import java.text.DecimalFormat;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.Jericho.spring.rest.model.Company;
import com.Jericho.spring.rest.model.CompanyDetail;
import com.Jericho.spring.rest.model.CompanyList;
import com.Jericho.spring.rest.model.ProductRecomendations;
import com.Jericho.spring.rest.model.Revenue;
import com.Jericho.spring.rest.model.TopProducts;

@Repository
public class CompanyDao {
	
	private DataSource dataSource;
    
    public CompanyDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
//	private static final Logger logger = LoggerFactory
//			.getLogger(CompanyDao.class);
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	Environment env;
	
	private CompanyList companyList;
	
	@Cacheable(value="myCache")
	public CompanyList findListOfCompanies(){
//		logger.debug("Inside findListOfCompanies start");
		setCompanyList();
		
		return companyList;
	}

	private void setCompanyList() {
		List<Company> companies = getCompanyListFromDB();
		companyList = new CompanyList();
		companyList.setCompanies(companies);
		companyList.setLastUpdate(""+new Timestamp(System.currentTimeMillis()));
	}

	public List<Company> getCompanyListFromDB() {
		List<Company> companies = new ArrayList<Company>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from JERICHO_DB.GBL_JRCH_COMPANY_PROFILE";
		
		jdbcTemplate.query(sql, new RowMapper<Company>() {

			@Override
			public Company mapRow(ResultSet resultSet, int arg1) throws SQLException {
//				logger.debug("Inside findListOfCompanies got resultset from db");
				Company company = new Company();
				company.setBusinessSector(resultSet.getString("BUSINESS_SECTOR"));
				company.setCompanyId(resultSet.getString("ECM_PRTY_ID"));
				company.setCompanyName(resultSet.getString("COMPANY_NAME"));
				//company.setLastUpdate(""+resultSet.getTimestamp(env.getProperty("LastUpdate")));
				company.setPermId(resultSet.getString("PERM_ID"));
				company.setRevenueRank(""+resultSet.getInt("REVENUE_RANK"));
				company.setRic(resultSet.getString("RIC"));
				company.setTicker(resultSet.getString("TICKER"));
				company.setWebsite(resultSet.getString("WEBSITE"));
				companies.add(company);
				return company;
			}
		});
		return companies;
	}
	
	public CompanyDetail findCompanyDetails(String permId){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql2 = "select * from JERICHO_DB.GBL_JRCH_COMPANY_PROFILE where PERM_ID = ?";
		CompanyDetail companyDetail = new CompanyDetail();
		
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);
		
		jdbcTemplate.queryForObject(sql2, new Object[]{permId},new RowMapper<CompanyDetail>() {
		
			
			
			@Override
			public CompanyDetail mapRow(ResultSet resultSet1, int arg1) throws SQLException {
				Company company = new Company();
				if(resultSet1 != null){
				company.setBusinessSector(resultSet1.getString("BUSINESS_SECTOR"));
				company.setCompanyId(resultSet1.getString("ECM_PRTY_ID"));
				company.setCompanyName(resultSet1.getString("COMPANY_NAME"));
				company.setPermId(resultSet1.getString("PERM_ID"));
				company.setRevenueRank(""+resultSet1.getInt("REVENUE_RANK"));
				company.setRic(resultSet1.getString("RIC"));
				company.setTicker(resultSet1.getString("TICKER"));
				company.setWebsite(resultSet1.getString("WEBSITE"));
				}
				companyDetail.setCompany(company);
				
				String sql3 = "select * from JERICHO_DB.GBL_JRCH_REVENUE_DTLS where PERM_ID = ?";
				
				List<Revenue> revenueList = jdbcTemplate.query(sql3,  new Object[]{permId},new RowMapper<Revenue>() {

					@Override
					public Revenue mapRow(ResultSet resultSet2, int arg1) throws SQLException {
						Revenue revenue = new Revenue();
						if(resultSet2 != null){
						revenue.setBusinessUnit(resultSet2.getString("BUSINESS_UNIT"));
						String CurrntPRevenue = (df.format(resultSet2.getLong("CRNT_PERIOD_REVENUE_USD")));
						revenue.setCurrentPeriodRevenue(""+CurrntPRevenue);
						String PriorPRevenue = (df.format(resultSet2.getLong("PRIR_PERIOD_REVENUE_USD")));
						revenue.setPriorPeriodRevenue(""+PriorPRevenue);
						}
						return revenue;
					}
				});
				companyDetail.setRevenue(revenueList);
				
				String sql4 = "select * from JERICHO_DB.GBL_JRCH_PRODUCT_RECOMDS where PERM_ID =?";
								
				List<ProductRecomendations> prodRecmList = jdbcTemplate.query(sql4,  new Object[]{permId},new RowMapper<ProductRecomendations>() {

					@Override
					public ProductRecomendations mapRow(ResultSet resultSet3, int arg1) throws SQLException {
						ProductRecomendations productRecomendations = new ProductRecomendations();
						if(resultSet3 != null){
						productRecomendations.setBusinessUnit(resultSet3.getString("RECOMMENDED_BU"));
						productRecomendations.setProductName(resultSet3.getString("RECOMMENDED_PRODUCT"));
						}
						return productRecomendations;
					}
				});
				companyDetail.setProductRecomendations(prodRecmList);
				
				String sql5 = "select P.BUSINESS_UNIT, R.CRNT_PERIOD_REVENUE_USD, R.PRIR_PERIOD_REVENUE_USD, P.REVENUE_RANK, P.PRODUCT_NAME  from JERICHO_DB.GBL_JRCH_PRODUCT_DTLS P , JERICHO_DB.GBL_JRCH_REVENUE_DTLS R where P.ECM_PRTY_ID = R.ECM_PRTY_ID and P.PERM_ID = R.PERM_ID  and P.BUSINESS_UNIT = R.BUSINESS_UNIT and P.PERM_ID =?";
				List<TopProducts> topProductsList = jdbcTemplate.query(sql5,  new Object[]{permId},new RowMapper<TopProducts>() {

					@Override
					public TopProducts mapRow(ResultSet resultSet4, int arg1) throws SQLException {
						TopProducts topProducts = new TopProducts();
						if(resultSet4 != null){
						topProducts.setBusinessUnit(resultSet4.getString("BUSINESS_UNIT"));
						String curntPeriodRev = (df.format(resultSet4.getDouble("CRNT_PERIOD_REVENUE_USD")));
						topProducts.setCurrentPeriodRevenue(""+curntPeriodRev);
						String prirPeriodRev = (df.format(resultSet4.getDouble("PRIR_PERIOD_REVENUE_USD")));
						topProducts.setPriorPeriodRevenue(""+prirPeriodRev);
						topProducts.setProductName(resultSet4.getString("PRODUCT_NAME"));
						Integer revRank = resultSet4.getInt("REVENUE_RANK");
						topProducts.setRevenueRank(""+revRank);
						}
						return topProducts;
					}
				});
				companyDetail.setTopProducts(topProductsList);
				return companyDetail;
			}
		});
		return companyDetail;
	}

	
	@CachePut(value="myCache")
	public void executeUpdate(){
		//update logic
		setCompanyList();
	}

}
