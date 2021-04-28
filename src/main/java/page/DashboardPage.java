package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage{
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Lib
	@FindBy(how=How.XPATH, using="//h2[contains(text(), 'Dashboard')]") WebElement DASHBOARD_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/a/span[1]") WebElement CUSTOMER_BUTTON_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement ADD_CUSTOMER_BUTTON_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_BUTTON_ELEMENT;
	
	//Interactive methods
	public void validateDashboardPage() {
		waitForElement(driver, 3, DASHBOARD_ELEMENT);
		Assert.assertEquals(DASHBOARD_ELEMENT.getText(), "Dashboard", "Dashboard page not found.");
	}
	
	public void clickCustomerButton() {
		CUSTOMER_BUTTON_ELEMENT.click();
	}
	
	public void clickAddCustomerButton() {
		ADD_CUSTOMER_BUTTON_ELEMENT.click();
	}
	
	public void clickListCustomerButton() {
		LIST_CUSTOMER_BUTTON_ELEMENT.click();
	}

}
