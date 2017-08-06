package PageFactoryPkg;

import org.openqa.selenium.WebElement;

public class PF_GenericMethod {
	
	public void MtdClick(WebElement ele){
		ele.click();
	}
	
	public void MtdEnterTxt(WebElement ele, String text){
		ele.sendKeys(text);
		
	}

}
