package org.common.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericTest{
	public static void main(String[] args){
		Byte m = new Byte((byte)1);
		Byte m1 = new Byte((byte)2);
		List list = new ArrayList<Byte>();
		list.add(m);
		list.add(m1);
		Byte min = Collections.max(list);
		System.out.println(min.getValue());
	}
}

interface Comparable<T> {
	public int comparableTo(T that);
}

class Byte implements Comparable<Byte>{
	private byte value;
	public Byte(byte value){
		this.value = value;
	}
	public byte getValue(){
		return value;
	}
	@Override
	public int comparableTo(Byte that) {
		return this.value - that.value;
	}
}

class Collections{
	public static <T extends Comparable<T>> T max(Collection<T> xs){      //  受限类型参数定义
		
		Iterator<T> xi = xs.iterator();
		T w = xi.next();
		while(xi.hasNext()){
			T x = xi.next();
			if(w.comparableTo(x) < 0){
				w = x;
			}
		}
		return w;
	}
}

