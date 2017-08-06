package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {

	public static String getval(String bwr) throws IOException{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\url.txt");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(bwr);
		
	}
}
