package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;

import org.hamcrest.Matchers.*;


public class AddPlace {

	String payload,baseURI="https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123";

	@Given("Add place payload")
	public void add_place_payload() {
	   
	payload= "{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \"Frontline house\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n"
			+ "    \"shop\"\r\n"
			+ "  ],\r\n"
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"French-IN\"\r\n"
			+ "}\r\n"
			+ "";
	}
	
	@When("User calls {string} with {string} request")
	public void user_calls_with_request(String string1, String string2) {
	   
		string1="addPlace";
		string2 = "POST";
		
		Response response = given().body(payload).when().post(baseURI);
		System.out.println("response: "+response.asString());
	}
	
	@Then("API returns success code {string}")
	public void api_returns_success_code(String string) {
	   
		 System.out.println("In then1");
	}
	
	@Then("{string} in response is {string}")
	public void in_response_is(String string, String string2) {
	   
		 System.out.println("In then2");
	}



}
