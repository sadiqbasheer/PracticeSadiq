package tests.data;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateLead {
	public String[][] readExcel() throws IOException
	{
		
		XSSFWorkbook wbook = new XSSFWorkbook("./data/CreateLeadDataSheet.xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		XSSFRow headerRow = sheet.getRow(0);
		short lastCellNum = headerRow.getLastCellNum();
		String[][] data = new String[lastRowNum][lastCellNum];
		for(int i=1; i<=lastRowNum; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				data[i-1][j] = stringCellValue;
				
			}
		}
		wbook.close();
		return data;
		
	}

}
