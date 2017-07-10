package com.webservice;

import java.util.List;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.webservice.requestpojo.getallproducts.Category;
import com.webservice.requestpojo.getallproducts.Category_;
import com.webservice.requestpojo.getallproducts.Category__;
import com.webservice.requestpojo.getallproducts.GetAllProductsResponsePojo;
import com.webservice.requestpojo.getallproducts.Market;
import com.webservice.services.Service;

public class GetAllProducts {
	//Service class has all the API
		Service service;
		Response responsedata;
	
		@Test
	public void getAllProductsTest(){
		service = new Service();
		responsedata = service.getAllProducts();
		System.out.println(responsedata.asString());
	    Gson gson = new Gson();
	    
	    //Instantiating response data as a  GetAllProductsResponsePojo class so all the object will be initialized
	    //setter is complete
	   GetAllProductsResponsePojo data = gson.fromJson(responsedata.asString(), GetAllProductsResponsePojo.class);
	   List<Category> getCategories = data.getCategories();
	   for(int i = 0; i < getCategories.size(); i++){
		   System.out.println(getCategories.get(i).getCategoryId()); 
			 System.out.println(getCategories.get(i).getCategoryType()); 
		   
	   }
	 System.out.println("-----------------------");
	 List<Category_> category_ = getCategories.get(0).getCategories();
	 for(int i = 0; i < category_.size(); i++){
		 System.out.println(category_.get(i).getSubCateogryId());
		 System.out.println(category_.get(i).getSubCatName()); 
		 System.out.println(category_.get(i).getType()); 
	 }
	 
	 
	System.out.println("----------------------------"); 
	
	 List<Category__> category__ = category_.get(0).getCategories();
	 for(int i =0; i<category__.size();i++){
		 System.out.println(category__.get(i).getCategoryName()); 
		 System.out.println(category__.get(i).getCategoryId()); 
		 System.out.println(category__.get(i).getEventId()); 
		 System.out.println(category__.get(i).getEventName()); 
	 }
	 
	Market getMarket = data.getMarket();
	getMarket.getBanner();
		
	}

}
