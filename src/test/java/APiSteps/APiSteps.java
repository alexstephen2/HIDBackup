package APiSteps;

import Actions.ReactTest;
import cucumber.api.java.en.*;

public class APiSteps {
	
	ReactTest rt = new ReactTest();
	
	@Given("^the user sends a GET request to Coinmap API$")
	public void the_user_sendsGET_Coinmap() throws Throwable {
		rt.APIGet();
	}
	
	@When("^the status code is 200$")
	public void Verify_Statuscode_Coinmap() throws Throwable {
		rt.APIVerify();
	}

	@When("^Count the total number of Categories$")
	public void CountTotalNumberofCategories() throws Throwable {
		rt.APICategoryCnt();
	}
	
	@When("^Extract the Names of Food Category$")
	public void ExtracttheNamesofFoodCategory() throws Throwable {
		rt.APIFoodCategory();
	}
	
}
