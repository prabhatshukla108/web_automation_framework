package com.psf.api.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ApiTest2 {
	
	@Test
	
	public static void getListofUsers() {
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data[4].first_name", equalTo("George")).
		log().all();
		
			
	}
//	/api/users/{id}
	
	@Test
	
	public void getSpecificUser() {
		// TODO Auto-generated method stub
		given()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.body("data.first_name", equalTo("Janet")).
		log().all();
	}
}
