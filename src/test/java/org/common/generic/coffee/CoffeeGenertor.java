package org.common.generic.coffee;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenertor implements Genertor<Coffee>, Iterable<Coffee>{

	private Class[] types = {Latter.class, Mocha.class};
	private static Random rand = new Random(47);
	public CoffeeGenertor(){}
	
	private int size = 0;
	public CoffeeGenertor(int sz){
		size = sz;
	}
	
	@Override
	public Coffee next() {
		try{
			return (Coffee)types[rand.nextInt(types.length)].newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	
	class CoffeeIterator implements Iterator<Coffee>{
		
		int count = size;
		
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenertor.this.next();
		}

		@Override
		public void remove() {
		}
		
	};
	

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}
	
	
	
	
	public static void main(String[] args){
		CoffeeGenertor gen = new CoffeeGenertor();
		for(int i = 0; i < 5; i++){
			  System.out.println(gen.next());
		}
		
		CoffeeGenertor gen1 = new CoffeeGenertor(5);
		Iterator<Coffee> iter = gen1.iterator();
		Coffee c = iter.next();
		while(iter.hasNext()){
			c = iter.next();
			System.out.println(c);
		}
	}

}
