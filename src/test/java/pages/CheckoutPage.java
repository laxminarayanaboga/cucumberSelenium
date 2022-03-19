package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import uiFactory.BasePage;
import uiFactory.WebDriverFactory;

public class CheckoutPage extends BasePage {

	@FindBy(xpath = "//div[contains(@class,'breadcrumb')]//span[text()='Your shopping cart']")
	WebElement yourShoppingCart;
	@FindBy(xpath = "//h1[@id='cart_title']//span[@id='summary_products_quantity']")
	WebElement summaryProductsQuantity;
	@FindBy(xpath = "//ul[@id='order_step']//li[1]")
	WebElement summaryTab;
	@FindAll(@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr"))
	List<WebElement> itemsInTheCart;
	@FindBy(xpath = "//table[@id='cart_summary']/tfoot//span[@id='total_price']")
	WebElement totalPrice;
	@FindBy(xpath = "//p//a[@title='Proceed to checkout']")
	WebElement proceedToCheckout;
	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;

	@Override
	public CheckoutPage initialize(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		return this;
	}

	public int getNumberOfItemsInTheCart() {
		WebDriverFactory.wait.until(ExpectedConditions.visibilityOf(yourShoppingCart));
		String numberOfProducts = WebDriverFactory.wait.until(ExpectedConditions.visibilityOf(summaryProductsQuantity))
				.getText();
		System.out.println("numberOfProducts: " + numberOfProducts);
		WebDriverFactory.wait.until(ExpectedConditions.visibilityOf(summaryTab));
		WebDriverFactory.wait.until(ExpectedConditions.visibilityOfAllElements(itemsInTheCart));
		return itemsInTheCart.size();
	}

	public String getTotalPrice() {
		return WebDriverFactory.wait.until(ExpectedConditions.visibilityOf(totalPrice)).getText();
	}

	public void proceedToCheckout() {
		scrollToElement(proceedToCheckout);
		proceedToCheckout.click();
	}

	public void waitForSignInStep() {
		WebDriverFactory.wait.until(ExpectedConditions.elementToBeClickable(submitLogin));
	}

}
