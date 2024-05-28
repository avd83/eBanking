package eBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import eBanking.testCase.BaseClass;

public class XLUtilis  {
	
	public static Logger logger;
	
	@DataProvider(name="loginDDT")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException
	{
		logger.info("intialize the test data excel ");
		String excelsheetname = m.getName();
		File f = new File(System.getProperty("user.dir")+ "\\src\\test\\java\\eBanking\\testData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheetname = workBook.getSheet(excelsheetname);
		
		int totalrows = sheetname.getLastRowNum();
		System.out.println(totalrows);
		Row rowcells = sheetname.getRow(0);
		int totalcols = rowcells.getLastCellNum();
		System.out.println(totalcols);
		
		DataFormatter df = new DataFormatter();
		
		String testData[][] = new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				 testData[i-1][j]=df.formatCellValue(sheetname.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		return testData;
		
	}

}
