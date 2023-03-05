package com.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import utility.Constants;
import utility.ExtentReportsUtility;

public class BaseTest {

	protected static WebDriver driver;
	protected static Logger logger;
	protected static ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();

	public WebDriver returnDriverInstance() {
		return driver;
	}

	public String getScreenshot(WebDriver driver) throws IOException {

		DateFormat dateformat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date1 = Calendar.getInstance().getTime();
		String date = dateformat.format(date1).toString();
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File imgFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(Constants.SCREENSHOT_PATH + date + ".png");
		FileHandler.copy(imgFile, destFile);
		return destFile.getAbsolutePath();
	}

	public String getData(int rownum, int cellnum) throws InvalidFormatException, IOException {
		FileInputStream fs = new FileInputStream(Constants.DATA_FILE);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(rownum);
		XSSFCell cell = row.getCell(cellnum);
		String s = null;
		if (cell.getCellType() == CellType.STRING) {
			s = cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			int val = (int) cell.getNumericCellValue();
			s = String.valueOf(val);
		}
		return s;
	}

}
