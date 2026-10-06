package com.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

/*
 * This class is used to provide data in synchronous manner
 * Data provider is used to read multiple sets of data from Excel File
 */

public class DataProviderUtility {
	
	/*
	 * @DataProvider helps sending multiple sets of data to test case
	 * @return
	 * @EncryptedDocumentException
	 * @IOException
	 */
	
	@DataProvider
	public Object[][] dataprovider() throws EncryptedDocumentException, IOException{
		
		FileInputStream fis = new FileInputStream("./src/test/resources/dataprovidertestdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("Sheet1");
		
		int lastrownum = sheet.getLastRowNum();
		short lastcellnum = sheet.getRow(0).getLastCellNum();
		
		Object[][] objarr = new Object[lastrownum][lastcellnum];
		
		for (int i = 1; i<=lastrownum; i++) {
			
			for(int j=0;j<lastcellnum;j++) {
				
				objarr[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
				
		}
			return objarr;

}}
