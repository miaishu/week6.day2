package week6.day2Assign;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata_Servicenow_Update {

	public static String[][] readExcel() throws IOException
	{
		XSSFWorkbook wb= new XSSFWorkbook("./excelGroup/ServiceNow_create.xlsx");
		XSSFSheet ws = wb.getSheet("Update");
		int rowCount = ws.getLastRowNum();
		short cellCount = ws.getRow(0).getLastCellNum();
		
		String[][] data= new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			XSSFRow row = ws.getRow(i);
		for(int j=0;j<cellCount;j++) {
			XSSFCell cell = row.getCell(j);
		
			String cellValue = cell.getStringCellValue();
			
			data[i-1][j]= cellValue;
			
		}}
		wb.close();
		
		return data;
			
		
	}
}
