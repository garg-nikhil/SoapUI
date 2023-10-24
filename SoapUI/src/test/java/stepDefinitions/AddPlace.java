package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPlace {


	@Given("Add place payload")
	public void add_place_payload() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("In given");
	}
	@When("User calls {string} with {string} request")
	public void user_calls_with_request(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("In when");
	}
	@Then("API returns success code {string}")
	public void api_returns_success_code(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("In then1");
	}
	@Then("{string} in response is {string}")
	public void in_response_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("In then2");
	}



}
