package DataProviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import GenericLibrary.dp_loginnew;

public class dp_login {
	
	@DataProvider(name="ValidLogin")
	public static Iterator<Object[]> validlogin() throws Exception{
		
		return dp_loginnew.data("Login", "ValidLogin");
		
	}
	
	@DataProvider(name="InvalidLogin")
	public static Iterator<Object[]> Invalidlogin() throws Exception{
		
		return dp_loginnew.data("Login", "InvalidLogin");
		
	}

}
