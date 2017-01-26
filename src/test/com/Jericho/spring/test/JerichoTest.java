package com.Jericho.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Jericho.spring.rest.controller.CompanyResource;
import com.Jericho.spring.rest.dao.CompanyDao;
import com.Jericho.spring.rest.model.Company;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class JerichoTest {
	
	private MockMvc mockMvc;

    @Mock
    private CompanyDao companyDao;

    @InjectMocks
    private CompanyResource companyController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(companyController)
                .build();
    }
    
    @Test
    public void test_get_all_success() throws Exception {
    	

        List<Company> company = Arrays.asList(
                new Company("ECM42006", "Belkin"),
                new Company("ECM42001", "Ameriprise Financial Inc"));
       // when(companyController.getCompanyList()).thenReturn(users);
        mockMvc.perform(get("/companylist"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is("ECM42006")))
                .andExpect(jsonPath("$[0].companyname", is("Belkin")))
                .andExpect(jsonPath("$[1].id", is("ECM42001")))
                .andExpect(jsonPath("$[1].companyname", is("Ameriprise Financial Inc")));
        verify(companyController, times(1)).getCompanyList();
        verifyNoMoreInteractions(companyController);
    }
    
    @Test
    public void test_get_by_id_success() throws Exception {
    	Company company = new Company("ECM42006", "Belkin");
        //when(companyController.getCompanyDetails("4295899980")).thenReturn(company);
        mockMvc.perform(get("/company/{id}", "4295899980"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is("ECM42006")))
                .andExpect(jsonPath("$.companyname", is("Belkin")));
        verify(companyController, times(1)).getCompanyDetails("4295899980");
        verifyNoMoreInteractions(companyController);
    }
    

}
