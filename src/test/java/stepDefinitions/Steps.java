package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchPage;
import uiFactory.WebDriverFactory;

public class Steps {
	HomePage homePage = new HomePage();
	SearchPage searchPage = new SearchPage();
	CheckoutPage checkoutPage = new CheckoutPage();

	@Given("I accessed the automationpractice website")
	public void i_accessed_the_automationpractice_website() {
		homePage.initialize(WebDriverFactory.driver).gotoHomePage();
	}

	@When("I search for summer dresses")
	public void i_search_for_summer_dresses() {
		homePage.searchFor("summer");
	}

	@When("Select products from the results and add to cart")
	public void select_products_from_the_results_and_add_to_cart() {
		// TODO: Generalize the method to define the number of products via feature file
		searchPage.initialize(WebDriverFactory.driver).selectProducts(2);
	}

	@When("Proceed with checkout process")
	public void proceed_with_checkout_process() {
		homePage.gotoCheckout();
		checkoutPage.initialize(WebDriverFactory.driver);
		Assert.assertEquals(2, checkoutPage.getNumberOfItemsInTheCart());
		String expectedTotalPrice = String.format("$%s", "61.48");
		Assert.assertEquals(expectedTotalPrice, checkoutPage.getTotalPrice());
		checkoutPage.proceedToCheckout();
		checkoutPage.waitForSignInStep();
	}

	@Then("I should be able to purchase the products")
	public void i_should_be_able_to_purchase_the_products() {
		// TODO: implement this step.
	}
}
