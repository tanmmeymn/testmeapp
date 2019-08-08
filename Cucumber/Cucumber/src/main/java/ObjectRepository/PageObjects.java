package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageObjects {

	@FindBy(how = How.XPATH, using ="//a[@href='login.htm']")
	public static WebElement signin;
	
	
}
