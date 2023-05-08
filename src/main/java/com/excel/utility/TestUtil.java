package com.excel.utility;

import java.util.ArrayList;
//import com.excel.utility.Xls_Reader;

public class TestUtil {

	public static ArrayList<Object[]> gedatafromexcel()
	
	{
		Xls_Reader reader = null;
	ArrayList<Object[]> mydata = new ArrayList<Object[]> ();
	try
	{
    reader = new Xls_Reader("C:\\Users\\Raja\\eclipse-workspace\\RBPOMtest\\src\\test\\java\\TestData\\Inputdata.xlsx");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	for(int rowNum=2; rowNum<=reader.getRowCount("CustomBus");rowNum++)
	{
	String Btype= reader.getCellData("CustomBus","Bustypes",rowNum);
	String BP= reader.getCellData("CustomBus","Boardingpoint",rowNum);
	Object ob[]= {Btype,BP};
	mydata.add(ob);
	}
	return mydata;
	}
}
