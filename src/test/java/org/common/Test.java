package org.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class Test {
	public static void main(String[] args) throws Exception{
		
		String connectStr = "jdbc:mysql://mysql.sql107.cdncenter.net/sq_haoyunlai3?useUnicode=true&characterEncoding=utf8";
		String username = "sq_haoyunlai3";
		String password = "AAAaaa000";
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn = DriverManager.getConnection(connectStr, username,password);  
		
		conn.setAutoCommit(false); // 设置手动提交  
		//  1  2  9  10
		String sql = "INSERT INTO stock_content(code,name,bus,market_date) VALUES(?,?,?,?)";
		String searchSql = "select * from stock_content where code = ?";
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
    	PreparedStatement searchPstmt = conn.prepareStatement(searchSql);
		
		FileInputStream fis=new FileInputStream("E:\\Table1.txt");
        InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line="";
        while ((line=br.readLine())!=null) {
        	line = line.replaceAll("\\s{1,}", " ");
        	String[] temps = line.split(" ");
        	if(temps.length > 1){
        		if(temps.length == 26){
        			System.out.println(temps[0]);
            		searchPstmt.setString(1, temps[1]);
                	ResultSet set = searchPstmt.executeQuery();
                	/*if(!set.next()){
                		pstmt.setString(1, temps[1]);pstmt.setString(2, temps[2]);pstmt.setString(3, temps[9]);
                		String str = temps[10].substring(0, 10);
                		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                		java.util.Date d = sdf.parse(str);
                		pstmt.setDate(4, new Date(d.getTime()));
                		pstmt.addBatch();
                	}*/
            	}
        	}
        }
        pstmt.executeBatch();
        conn.commit();  // 提交 
        conn.close();
	}
}
