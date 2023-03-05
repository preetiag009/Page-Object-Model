package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtility {
//	File file = new File(Constants.DATA_FILE);
//	FileInputStream stream = new FileInputStream (file);
	
	public String getStringData(int rownum, int cellnum) throws InvalidFormatException, IOException {
	XSSFWorkbook workbook = new XSSFWorkbook(new File(Constants.DATA_FILE));
	XSSFSheet sheet= workbook.getSheet("Sheet1");
	XSSFRow row = sheet.getRow(rownum);
	XSSFCell cell = row.getCell(cellnum);
	return cell.getStringCellValue();
	}
	
	

}

