package com.excel.utility;

import java.util.ArrayList;
//import com.excel.utility.Xls_Reader;

public class TestUtil {

	public static ArrayList<String[]> gedatafromexcel()
	//initially it was public static ArrayList<Object[]> gedatafromexcel()
	{
		Xls_Reader reader = null;	
		ArrayList<String[]> mydata = new ArrayList<String[]> ();
		//initially it was ArrayList<Object[]> mydata = new ArrayList<Object[]> ();
		//This arraylist is going to contain collection of  items in the type of string
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
			String ob[]= {Btype,BP};
			//initially it was object ob[]={Btype,BP};
			mydata.add(ob);
		}
		return mydata;
	}
}
