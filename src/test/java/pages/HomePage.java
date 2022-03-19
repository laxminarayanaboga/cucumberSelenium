package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import uiFactory.BasePage;
import uiFactory.WebDriverFactory;

public class HomePage extends BasePage {
	@FindBy(xpath = "//header//nav//a[@title='Log in to your customer account']")
	WebElement signIn;
	@FindBy(xpath = "//div[@id='search_block_top']//form[@id='searchbox']//input[@id='search_query_top']")
	WebElement searchTextBox;
	@FindBy(xpath = "//div[@id='search_block_top']//form[@id='searchbox']//button[@name='submit_search']")
	WebElement searchButton;

	@FindBy(xpath = "//header//a[@title='View my shopping cart']")
	WebElement shoppingCart;

	public HomePage initialize(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		return this;
	}

	public void gotoHomePage() {
		WebDriverFactory.driver.get("http://automationpractice.com/index.php");
		WebDriverFactory.wait.until(ExpectedConditions.visibilityOf(searchTextBox));
	}

	public void searchFor(String searchString) {
		WebDriverFactory.wait.until(ExpectedConditions.visibilityOf(searchTextBox));
		searchTextBox.sendKeys(searchString);
		WebDriverFactory.wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}

	public void gotoCheckout() {
		WebDriverFactory.wait.until(ExpectedConditions.elementToBeClickable(shoppingCart)).click();
	}

}
