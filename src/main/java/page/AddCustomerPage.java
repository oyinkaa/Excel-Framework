package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AddCustomerPage extends BasePage{

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Lib
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement USERNAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHOME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement CUNTRY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SUBMIT_BUTTON_LOCATOR;


	// Interactive methods
	String enteredName;
	public void insertFullName(String fullName) {
		
		int generatedNubmer = randomGenerator(999);
		enteredName = fullName + generatedNubmer;
		USERNAME_FIELD_LOCATOR.sendKeys(enteredName);
	}


	public void chooseCompanyOption(String company) {
			
		selectDropDown(COMPANY_FIELD_LOCATOR, company);
		
	}
	
	public void insertEmail(String email) {
		int generatedNubmer = randomGenerator(999);
		EMAIL_FIELD_LOCATOR.sendKeys(generatedNubmer + email);
	}
	
	public void insertPhoneNumber(String phone) {
		int generatedNubmer = randomGenerator(999);
		PHOME_FIELD_LOCATOR.sendKeys(generatedNubmer + phone);
	}
	
	public void insertAddress(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}
	
	public void insertCity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}
	
	public void chooseCountryOption(String country) {
		selectDropDown(CUNTRY_FIELD_LOCATOR, country);
	}
	
	public void insertState(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}
	
	public void insertZip(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}
	
	public void clickSubmitButton() {
		SUBMIT_BUTTON_LOCATOR.click();
	}
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	//tbody/tr[i]/td[3]/following-sibling::td[4]/a[2]
	
	public void verifyEnteredNameAndDelete() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		
		for(int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			/*System.out.println(name);
			Assert.assertEquals(name, enteredName, "Entered name doesn't match");
			break;*/
			
			if(name.contains(enteredName)) {
				System.out.println("entered name exist.");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
//				driver.findElement(By.xpath(before_xpath + i + after_xpath + "/following-sibling::td[4]/a[2]")).click();
			}
		}
	}
	

}
