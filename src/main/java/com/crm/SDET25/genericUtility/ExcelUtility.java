package com.crm.SDET25.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method will return string values of sheetName, rowNum and cellNum 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getDataFromExcelSheet(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream(IpathConstants.EXCEL_PATH);
	Workbook workbook = WorkbookFactory.create(file);		
	return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		
	}
	
	/**
	 * This method will write the data into excel sheet 
	 * @throws Throwable
	 */
	
	public void writeTheData(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream file = new FileInputStream(IpathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		
		FileOutputStream file2 = new FileOutputStream(IpathConstants.EXCEL_PATH);
		workbook.write(file2);
		workbook.close();	
	}
	
	/**
	 * This method will return multiple data from excel sheet
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] getMultipleData() throws Throwable {
	FileInputStream fis = new FileInputStream(IpathConstants.EXCEL_PATH);
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("Sheet1");
	int rowNo = sheet.getPhysicalNumberOfRows();
	System.out.println(rowNo);
	int cellNo = sheet.getRow(0).getLastCellNum();
	System.out.println(cellNo);
	Object[][] data = new Object[rowNo][cellNo];
	for (int i=0; i<rowNo; i++) {
		for (int j=0;j<cellNo;j++) {
			data[i][j]=sheet.getRow(i).getCell(j).toString();
		}
	}
	return data;
	}
	
	/**
	 * This method is used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  = new FileInputStream(IpathConstants.EXCEL_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	

}

