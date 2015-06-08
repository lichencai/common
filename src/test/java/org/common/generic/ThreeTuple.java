package org.common.generic;
/**
 * 实现一个元组里面有三个
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B>{
	
	public final C three;
	
	public ThreeTuple(A a, B b, C c){
		super(a, b);
		this.three = c;
	}
	
	public String toString(){
		return "(" + first + "," + second + "," + three + ")";
	}
	
}
