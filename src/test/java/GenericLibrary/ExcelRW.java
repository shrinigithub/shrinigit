package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	
	FileInputStream fis;
	XSSFWorkbook wb;
	
	
	@SuppressWarnings("resource")
	public ExcelRW(String fpath) throws IOException{
		
		fis = new FileInputStream(fpath);
		
		wb = new XSSFWorkbook(fis);
		
	}

	public int rowcount(String sheetname){
		
		XSSFSheet sheet = wb.getSheet(sheetname);
		int rc = sheet.getLastRowNum();
		return rc;
	}
	
	public int colcount(String sheetname){
		
		XSSFSheet sheet = wb.getSheet(sheetname);
		short cc = sheet.getRow(0).getLastCellNum();
		return cc;
		
	}
	
	public String readval(String sheetname, int r, int c){
		
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		XSSFCell cell = sheet.getRow(r).getCell(c);
		
		String cellval=null;
		
		if (cell.getCellType()==cell.CELL_TYPE_STRING){
			
			cellval = cell.getStringCellValue();
		}else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
			
			cellval = String.valueOf(cell.getNumericCellValue());
		}else if(cell.getCellType()==cell.CELL_TYPE_BLANK){
			
			cellval =" ";
		}
		return cellval;
	}
	
	public void writeval(String sheetname, int r, int c, String text){
		
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		sheet.getRow(r).getCell(c).setCellValue(text);
		
		
	}
	
	@SuppressWarnings("resource")
	public void saveandclose(String fpath) throws IOException{
		
		FileOutputStream fos = new FileOutputStream(fpath);
		
		wb.write(fos);
		fis.close();
		fos.close();
		
	}
}
