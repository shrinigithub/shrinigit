package PageFactoryPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PF_LoginPage extends PF_GenericMethod{
	
	@FindBy(name="logid")
	public WebElement uname_pf;
	
	@FindBy(name="pswd")
	public WebElement pwd_pf;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	public WebElement LoginBtn;
	
	public PF_LoginPage(WebDriver driver){
	PageFactory.initElements(driver, this);
	}
	
	public void PFMtdLogin(String uname, String pwd){
		MtdEnterTxt(uname_pf,uname);
		MtdEnterTxt(pwd_pf,pwd);
		MtdClick(LoginBtn);
		
	}
	
}
