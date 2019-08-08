package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeObjects {

	
	@FindBy(name = "products")
	 
	public WebElement searchtextbox;

	 
	@FindBy(how = How.XPATH, xpath ="//input[@value='FIND DETAILS']")
	 
	public WebElement finddetailsbutton;

	

	}

