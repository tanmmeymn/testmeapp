package Cucumber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ObjectRepository.LoginObjects;
import ObjectRepository.PageObjects;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginFeatureStepDefinition {
	int productcount=0;
	static WebDriver driver;

	@Given("Navigate to home page")

	public void Navigate_to_home_pages() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://10.232.237.143:443/TestMeApp/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("user enters username and password")

	public void userEntersUsernameAndPassword() throws Throwable {
		PageObjects po = PageFactory.initElements(driver,PageObjects.class);
		 
		LoginObjects lo = PageFactory.initElements(driver,LoginObjects.class);

		po.signin.click();
		 
		lo.username.sendKeys("Lalitha");
		 
		lo.password.sendKeys("password123");
		 
		lo.Login.click();


		}


	@Then("^user logged in sucessfully$")
	public void userLoggedInSucessfully() throws Throwable {
	//Assert.assertEquals(driver.getTitle(),"Admin Home");
		driver.quit();
	
	}

	@When("user searches for below products in the search box :")
	public void userSearchesForBelowProductsInTheSearchBox(DataTable productsdata) throws Throwable {
		List<String>productsName=productsdata.asList(String.class);
		Navigate_to_home_pages();
		userEntersUsernameAndPassword();
		 for (String products: productsName)
		 {
			 driver.findElement(By.name("products")).sendKeys(products);

			 driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();

			  boolean found = isElementPresent("//a[text()[contains(.,'Add to cart')]]");
			  	if (found) {
			  		productcount++;
			  	}
			 driver.findElement(By.xpath("//a[text()[contains(.,'Home')]]")).click();

		 }
	}

	@Then("product should be aded in the cart if available")
	public void productShouldBeAdedInTheCartIfAvailable() throws Throwable {
		WebElement addtocart =driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/a/b"));
		
		int  numberofelement =Integer.parseInt(addtocart.getText());
		Assert.assertEquals(productcount,numberofelement);
	}
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userEntersAnd(String arg1, String arg2) throws Throwable {
		PageObjects po = PageFactory.initElements(driver,PageObjects.class);
		 
		LoginObjects lo = PageFactory.initElements(driver,LoginObjects.class);

		po.signin.click();
		 
		lo.username.sendKeys(arg1);
		 
		lo.password.sendKeys(arg2);
		 
		lo.Login.click();
	}

	public static boolean isElementPresent(String locator) {

        int attempts = 0;

        boolean found = false;

        while (attempts < 2) {

               try {

                     WebElement element = driver.findElement(By.xpath(locator));

                     element.click();

                     found = true;

                     break;

               } catch (Exception e) {

               }

               attempts++;

        }

        return found;

  }

}
