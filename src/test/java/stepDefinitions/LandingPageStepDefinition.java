package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.GenericUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LandingPageStepDefinition {

    public WebDriver driver=GenericUtils.initializeDriver();
    public LandingPage landingPage= new LandingPage(driver);

    public LandingPageStepDefinition() throws IOException {
    }

    @Given("User is on Amazon Landing page")
    public void user_is_on_amazon_landing_page() throws IOException {
        Assert.assertEquals("Amazon.com. Spend less. Smile more.",landingPage.getTitleLandingPage() ,"Title is Verified");
    }
    @When("^user searched with (.+) in search bar$")
    public void user_searched_with_iphone_in_search_bar(String name) {
    landingPage.searchItem(name);
    }
    @Then("^user validate the first result contains name as (.+)$")
    public void user_validate_the_first_result_contains_name_as_apple_i_phone(String name) throws InterruptedException {
        List<WebElement> a= new ArrayList(landingPage.getResultList());
        String ResultFirstname=a.get(0).getText();
//        System.out.println(ResultFirstname);
        Assert.assertTrue(ResultFirstname.contains(name));
        driver.quit();

    }


}
