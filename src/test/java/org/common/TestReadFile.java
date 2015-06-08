package org.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestReadFile {
	public static void main(String[] args) throws Exception{
		
		String str = "110000";
		System.out.println(Integer.parseInt(str));
		
		
		/*FileInputStream fis=new FileInputStream("E:\\123123.txt");
        InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line="";
        String str = "";
        while ((line=br.readLine())!=null) {
        	str = str + line.trim();
        }
        br.close();
        isr.close();
        fis.close();
		System.out.println(str);*/
	}
}
