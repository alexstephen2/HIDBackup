package StepDefn;

import Actions.ReactTest;
import cucumber.api.java.After;
import cucumber.api.java.en.*;


public class Stepdfn {
	
	ReactTest rt = new ReactTest();
	
	@Given("^the user navigates to ReactJs Website$")
	public void the_user_navigates_to_ReactJs_Website() throws Throwable {
		rt.driverinit(); 
	}
	
	@When("^the user opens the DOCS page$")
	public void the_user_opens_the_DOCS_page() throws Throwable {
		rt.docstab();    
	}

	@Then("^Highlight Main Concepts Links and download Sub link names to a file$")
	public void expand_Main_Concepts_and_Highlight_all_the_sub_links() throws Throwable {
		rt.MainConcepts();
	    
	}

	@Then("^Highlight Advanced Guide Links and download Sub link names to a file$")
	public void expand_AdvancedGuides_and_Highlight_all_the_sub_links() throws Throwable {
		rt.AdvanceLinks();
	   
	}
	
	@When("^the user opens the Tutorials page$")
	public void the_user_opens_the_tutorials_page() throws Throwable {
		rt.tutorials();    
	}
	
	@When("^user scrolls to Topic \"([^\"]*)\"$")
	public void user_scrolls_to_Topic(String tutorialTopic) throws Throwable {
		rt.scrolltoTutor(tutorialTopic);
	}
	
	@When("^Verify the Scroll Navigation Index Page$")
	public void verify__the_scroll_pagenavigation() throws Throwable {
		rt.ScrollVerify();   
	}
	
	 @After
	public void Aftercleanup() throws Throwable {
			rt.closedriver();   
		}

}
