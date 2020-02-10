package com.rakuten.first.demo;


import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonExtraction {
@Test
public void test1() {
given().get("http//localhost:8080/Books").then().statusCode(200).log().all();
	
}
}
