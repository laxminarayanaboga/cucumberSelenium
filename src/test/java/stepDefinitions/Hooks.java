package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import uiFactory.WebDriverFactory;

public class Hooks {
	@Before
	public void beforeHookMethod() {
		System.out.println("beforeHookMethod triggered");
		WebDriverFactory.initiateDriver();
		WebDriverFactory.initiateWait();
	}

	@After
	public void afterHookMethod() {
		System.out.println("afterHookMethod triggered");
		WebDriverFactory.driver.quit();
	}
}
