package PageFactoryPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PF_HomePage extends PF_GenericMethod {
	
	@FindBy(linkText="Sign In")
	public WebElement SignInLink;
	
	public PF_HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void SignInLink_Click(){
		MtdClick(SignInLink);
	}

}
