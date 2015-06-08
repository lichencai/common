package org.common.generic;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException{
		//  List<String>[] lso = new ArrayList<String>[10];   不能创建
		//Class c = Main.class;
		Class<?> c = Class.forName("org.common.generic.Main");
		
		System.out.println(c);
		
	}
}
