package org.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws Exception{
		String strPath = "F:\\11.xlsx";
		InputStream in = new FileInputStream(new File(strPath));
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径  
		XSSFWorkbook xwb = new XSSFWorkbook(in);  
		// 读取第一章表格内容  
		XSSFSheet sheet = xwb.getSheetAt(2);  
		// 定义 row、cell  
		XSSFRow row;  
		String cell; 
		String str = "INSERT INTO CC.`CC_REQ_REQTYPE` VALUES(";
		// 循环输出表格中的内容  
		for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {  
		    row = sheet.getRow(i);  
		    for (int j = row.getFirstCellNum(); j <= row.getPhysicalNumberOfCells(); j++) {  
		        // 通过 row.getCell(j).toString() 获取单元格内容，
		    	if(row.getCell(j) != null){
		    		XSSFCell each = row.getCell(j);
		    		if((j == 0 || j == 1 || j == 6 || j == 8 || j == 9 || j == 12) && i != 0 && i != 1){
		    			cell = String.valueOf((int)each.getNumericCellValue());
		    		}else{
		    			cell = row.getCell(j).toString();  
		    			if("".equals(cell)){
		    				cell = "NULL";
		    			}
		    		}
		    		if(!"NULL".equals(cell))
		    			str += "\'" + cell + "\',";
		    		else
		    			str += "NULL" + ",";
		    	}else{
		    		str += "NULL" + ",";
		    	}
		    }  
		    str = str.substring(0, str.length() - 1) + ");";
		    System.out.println(str);  
		    str = "INSERT INTO CC.`CC_REQ_REQTYPE` VALUES(";
		}
	}
}
