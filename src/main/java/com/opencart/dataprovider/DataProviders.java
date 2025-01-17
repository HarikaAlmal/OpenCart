/**
 * 
 */
package com.opencart.dataprovider;

import org.testng.annotations.DataProvider;

import com.opencart.utility.ExcelLibrary;

/**
 * @author harik
 *
 */
public class DataProviders {

	
	ExcelLibrary obj = new ExcelLibrary(); 
	
	@DataProvider(name = "Credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		System.out.println("im here");

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}
}
