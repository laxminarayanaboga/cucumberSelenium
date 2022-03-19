package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import uiFactory.BasePage;
import uiFactory.WebDriverFactory;

public class SearchPage extends BasePage {
	@FindBy(xpath = "//h1[contains(text(),'Search')]")
	WebElement searchTitle;
	@FindBy(id = "selectProductSort")
	WebElement selectProductSort;
	@FindAll(@FindBy(xpath = "//ul[@class='product_list grid row']//li"))
	List<WebElement> searchResults;

	@FindBy(xpath = "//div[@id='layer_cart']//i[@class='icon-ok']")
	WebElement okElement;
	@FindBy(xpath = "//div[@id='layer_cart']//div//span[@title='Continue shopping']/span")
	WebElement continueShopping;

	final String searchResultItem = "//ul[@class='product_list grid row']//li[%d]//div[@class='product-container']";

	@Override
	public SearchPage initialize(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		return this;
	}

	public void selectProducts(int numberOfProducts) {

		for (int i = 1; i <= numberOfProducts; i++) {
			String currentProductXpath = String.format(searchResultItem, i);
			WebDriverFactory.wait
					.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath(currentProductXpath))));
			WebElement quickView = this.driver
					.findElement(By.xpath(currentProductXpath + "//a[@class='product_img_link']"));
			Actions actions = new Actions(this.driver);
			actions.moveToElement(quickView).perform();
			By addToCart = By.xpath(currentProductXpath + "//a[@title='Add to cart']");
			WebDriverFactory.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(addToCart))).click();
			hardWait(500);
			WebDriverFactory.wait.until(ExpectedConditions.visibilityOf(okElement));

			WebDriverFactory.wait.until(ExpectedConditions.elementToBeClickable(continueShopping)).click();
			WebDriverFactory.wait.until(ExpectedConditions.invisibilityOf(continueShopping));

		}

	}

}
