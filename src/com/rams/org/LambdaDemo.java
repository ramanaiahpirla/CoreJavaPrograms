package com.rams.org;

import java.util.function.BiConsumer;

public class LambdaDemo {

	public static void main(String[] args) {
		BiConsumer<Integer, Integer> biConsumer = (a,b) -> System.out.println(a+b);
		biConsumer.accept(10, 20);
		
	
		BiConsumer<Integer, Integer> response = (a,b) -> System.out.println(a * b);
		response.accept(10, 20);
	}
	

}
