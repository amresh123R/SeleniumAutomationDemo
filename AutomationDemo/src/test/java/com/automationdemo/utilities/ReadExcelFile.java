package com.automationdemo.utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo)
	{
		try
		{
			inputStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			cell = excelSheet.getRow(rowNo).getCell(cellNo);
			
			workBook.close();
			
			return cell.getStringCellValue();
			
		}
		catch(Exception e)
		{
			return "Excel file is not loaded properly";
		}
	}

	public static int getRowCount(String fileName, String sheetName)
	{
		try {
			inputStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			int ttlRow = excelSheet.getLastRowNum() + 1;
			workBook.close();
			return ttlRow;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	public static int getCellCount(String fileName, String sheetName)
	{
		try {
			inputStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			int ttlCell = excelSheet.getRow(0).getLastCellNum();
			workBook.close();
			return ttlCell;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	public String getStringData(int sheetIndex, int row, int column)
	{
		return workBook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row, int column)
	{
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int column)
	{
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	
}
