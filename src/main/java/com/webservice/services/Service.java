package com.webservice.services;


import org.json.JSONObject;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.webservice.requestpojo.Login;
import com.webservice.requestpojo.Loginpojo;

public class Service {
	
	//login method
	/**This API will perform login operation	 
	 * @param loginId
	 * @param loginSource
	 * @param password
	 * @return
	 */
	public Response login(String loginId,String loginSource,String password ){
		
		//post to the server we will get response
		
		try {
			Loginpojo loginpojo = new Loginpojo();
			Login login = new Login();
			login.setLoginId(loginId);
			login.setLoginSource(loginSource);
			login.setPassword(password);
			loginpojo.setLogin(login);
			//converting pojo to json
			JSONObject jsonobject = new JSONObject(loginpojo);
			//
			RequestSpecification requestSpecification = RestAssured.given();
			//json header
			requestSpecification.header("content-type", "application/json");
			//posting data to the server as a string using created json object
			requestSpecification.body(jsonobject.toString());
			Response response = requestSpecification.post(URLbuilder.loginurl);
			return response;
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		return null;
		
	}
	
	public Response getAllProducts(){
		RequestSpecification requestSpecification = RestAssured.given();
		//json header
		requestSpecification.header("content-type", "application/json");
		Response response = requestSpecification.get(URLbuilder.allproducturl);
		System.out.println(response.asString());
		return response;
		
		
	}
	
	public static void main(String[] args) {
		//Service obj = new Service();
		//obj.login("info.bhanupratap@gmail.com", "APP", "password");
		
	}

}
