package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public int randomGenerator(int bound) {
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(bound);
		return randomNumber;

	}

	public void selectDropDown(WebElement elementLocator, String visibleText) {
		Select sel = new Select(elementLocator);
		sel.selectByVisibleText(visibleText);

	}

	public void waitForElement(WebDriver driver, int timeInSecomds, WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver, timeInSecomds);
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

}
