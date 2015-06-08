package org.common.generic;

/**
 * 这是一个元组，可以返回多个对象时候使用
 */
public class TwoTuple<A, B> {
	public final A first;		//  设置为final可以使得对象不再改变， 如果在构造函数中没有使用赋值，则final声明的对象要给予原始值
	public final B second;		//
	public TwoTuple(A a, B b){
		this.first = a;
		this.second = b;
	}
	
	public String toString(){
		return "(" + first + "," + second + ")";
	}
	
}
