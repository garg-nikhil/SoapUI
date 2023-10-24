package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers.*;
import pojo.AddPlace.*;

public class AddPlace {

	String payload, baseURI = "https://rahulshettyacademy.com/maps/api/place/add/json";
	Response response;
	AddPlaceRequest addplace;

	@Given("Add place payload")
	public void add_place_payload() {

		// RequestSpecification req = new RequestSpecBuilder().setBody(baseURI).set

		addplace = new AddPlaceRequest();
		addplace.setAccuracy(50);
		addplace.setName("Nikhil");
		addplace.setPhone_number("7267655102");
		addplace.setAddress("Pune");
		addplace.setWebsite("Faltu");
		addplace.setLanguage("French");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		addplace.setTypes(myList);

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		addplace.setLocation(l);

	}

	@When("User calls {string} with {string} request")
	public void user_calls_with_request(String string1, String string2) {

		string1 = "addPlace";
		string2 = "POST";
		response = given().log().all().baseUri(baseURI).queryParams("key", "qaclick123").body(addplace).post();
		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseURI).addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();
		
	}

	@Then("API returns success code {int}")
	public void api_returns_success_code(Integer statusCode) {

		int response1 = response.statusCode();
		// System.out.println("response: "+response.asString());

		if (response1 == statusCode) {
			System.out.println("TC is working fine");
		} else
			System.out.println("TC is failing miserably..");
	}

	@Then("{string} in response is {string}")
	public void in_response_is(String string, String string2) {

		/*
		 * String contentType= response.getContentType();
		 * System.out.println("contentType: "+contentType);
		 */
		String abc = response.then().assertThat().contentType("application/json;charset=UTF-8").statusCode(200)
				.extract().asString();
		System.out.println("ValidatableResponse: " + abc);
	}

}
