package com.webservice;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.webservice.responsepojo.login.CustomerWrapper;
import com.webservice.responsepojo.login.Customers;
import com.webservice.responsepojo.login.LoginResponsePojo;
import com.webservice.services.Service;

import junit.framework.Assert;

public class LoginAPITest {
	
	//Service class has all the API
	Service service;
	Response responsedata;
	
	@Test
	public void loginAPITest(){
		service = new Service();
		//parse response data
	    responsedata = service.login("info.bhanupratap@gmail.com", "APP", "password");
	    System.out.println(responsedata.asString());
	    Gson gson = new Gson();
	    
	    //Instantiating response data as a  LoginResponsePojo class so all the object will be initialized
	   LoginResponsePojo data = gson.fromJson(responsedata.asString(), LoginResponsePojo.class);
	   
	   
	    CustomerWrapper customerWrapper = data.getCustomerWrapper();
	    System.out.println(customerWrapper.getResponseCode());
	    Customers getcustomers = customerWrapper.getCustomers();
	    
	    //can access any data only get method since this is response
	    System.out.println(getcustomers.getCreateDate());
	    System.out.println(getcustomers.getDateOfBirth());
	    
	    Assert.assertEquals(getcustomers.getCreateDate(), "2012-05-08T14:08:36+05:30");
	    Assert.assertEquals(getcustomers.getDateOfBirth(), "1987-01-01T00:00:00+05:30");
	    Assert.assertEquals(customerWrapper.getResponseCode(), "SUCCESS");
	    
	}

}
