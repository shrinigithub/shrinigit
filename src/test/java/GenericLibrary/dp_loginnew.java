package GenericLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class dp_loginnew {
	
//	@DataProvider(name="LoginData")
	public static Iterator<Object[]> data(String sheetname, String scriptname) throws Exception
	{
		
		ExcelRW excelRW = new ExcelRW("C:\\Users\\Shrini\\Desktop\\Test_Data.xlsx");
//		ExcelRW excelRW = new ExcelRW("C:\\Users\\Shrini\\Desktop\\Test_Data.xlsx");
		
		int rc = excelRW.rowcount(sheetname);
		int cc = excelRW.colcount(sheetname);
		ArrayList<Object[]> al = new ArrayList<Object[]>();
			
		for(int i=1;i<=rc; i++){
			
			String script = excelRW.readval(sheetname, i, 1);
			String flag = excelRW.readval(sheetname, i, 2);
			if (script.equals(scriptname) && flag.equals("Y")){
			HashMap<String, String> hmap = new HashMap<String, String>();
			
			for(int j=0;j<cc;j++){
				String key = excelRW.readval(sheetname, 0, j);
				String value = excelRW.readval(sheetname, i, j);
				
				hmap.put(key, value);
			}
			Object[] Obj=new Object[1];
			Obj[0]=hmap;
			al.add(Obj);
		}
		}
		return al.iterator();
		
	}

}
