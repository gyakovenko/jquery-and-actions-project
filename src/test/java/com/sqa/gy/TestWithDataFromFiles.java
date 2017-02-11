package com.sqa.gy;

import java.sql.*;

import org.testng.annotations.*;

import com.sqa.gy.helpers.*;
import com.sqa.gy.helpers.exceptions.*;

public class TestWithDataFromFiles extends BasicTest {

	public TestWithDataFromFiles() {
		super("https://www.amazon.com");
	}

	@DataProvider
	public Object[][] excel2003Data() throws InvalidExcelExtensionException {
		Object[][] data = DataHelper.getExcelFileData("", "products.xls", false);
		return data;
	}

	@DataProvider
	public Object[][] excelNewData() throws InvalidExcelExtensionException {
		Object[][] data = DataHelper.getExcelFileData("", "products.xlsx", false);
		return data;
	}

	@DataProvider
	public Object[][] fromSQL1() throws ClassNotFoundException, SQLException, DataTypesMismatchException,
			DataTypesCountException, DataTypesTypeException {
		getLogger().info("Getting data from db and passing it");
		Object[][] dataForTesting = DataHelper.evalDatabaseTable("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:8889/Amazon_db1", "root", "root", "products");
		return dataForTesting;
	}

	@Test(enabled = false) // (dataProvider = "excel2003Data")
	public void testAmazon(Double id, String product, Double quantity, Double totalPrice)
			throws ClassNotFoundException, SQLException {
		System.out.println("Amazon Test");
		System.out.println(
				"You searched for " + quantity + " items of " + product + " which will cost a total of " + totalPrice);
	}

	@Test(enabled = false)
	public void testAmazon2003() throws InvalidExcelExtensionException {
		System.out.println("Amazon Test 2003");
		Object[][] data2003 = excel2003Data();
		DataHelper.displayData(data2003);
	}

	@Test(dataProvider = "excelNewData")
	public void testAmazonNew(Double id, String product, Double quantity, Double totalPrice)
			throws ClassNotFoundException, SQLException, InvalidExcelExtensionException {
		System.out.println("Amazon Test New");
		System.out.println(
				"You searched for " + quantity + " items of " + product + " which will cost a total of " + totalPrice);
	}

}
