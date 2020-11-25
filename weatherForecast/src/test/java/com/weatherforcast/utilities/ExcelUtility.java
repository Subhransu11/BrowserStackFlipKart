package com.weatherforcast.utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	 private XSSFSheet wSheet;	 
	 private XSSFWorkbook wBook;	 
	 String[][] data;
	 
	 public Object[][] readExcel() {
		 FileInputStream fs;
		 try {
			fs = new FileInputStream(".//Extrenal Files//WeatherForecast.xlsx");
			wBook = new XSSFWorkbook(fs);
			wSheet = wBook.getSheet("Temperature");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 int lastRow = wSheet.getLastRowNum();
		 System.out.println(lastRow);
		 int lastColumn = 1;//wSheet.getRow(0).getLastCellNum();
		 
		 data = new String[lastRow][lastColumn];
		 
		 for(int i=1;i<=lastRow;i++) {
			 for(int j =0; j<lastColumn;j++) {
				 data[i-1][j]= wSheet.getRow(i).getCell(j).toString();
			 }
		 }
		 
		 for(int i=1;i<=lastRow;i++) {
			 for(int j =0; j<lastColumn;j++) {
				 System.out.println(data[i-1][j]);
			 }
		 }
		 		 
		 return data;
	 }
}
