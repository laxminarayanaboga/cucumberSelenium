package uiFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	public abstract BasePage initialize(WebDriver driver);

	protected WebDriver driver;
	protected WebDriverWait wait;

	protected void scrollToElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	protected void hardWait(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
