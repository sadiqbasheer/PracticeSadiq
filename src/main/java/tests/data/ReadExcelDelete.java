package tests.data;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

public class ReadExcelDelete {
	public String[][] data ;
	public String[][] readData(String fileName) throws IOException
	{
		//creating work book
		XSSFWorkbook wbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		//locating the sheet
		XSSFSheet sheet = wbook.getSheetAt(0);
		//get row count
		int rowCount = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		data = new String[rowCount][colCount];
		
		for (int i = 1; i <=rowCount; i++) {
			XSSFRow row2 = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row2.getCell(j);
				String cellValue = cell.getStringCellValue();
				data[i-1][j]=cellValue;
				
			}
			
		}
		wbook.close();
		return data;
		
	}

}
