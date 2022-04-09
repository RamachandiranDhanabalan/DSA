package com.learning.dsa.recursion;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
		System.out.println(factorial1(5));
	}
	
	public static int factorial(int number) {
		if(number<=1) {
			return number;
		}
		return number*factorial(--number);
	}
	
	public static int factorial1(int number) {
		int fact=5;
		for(int i=2;i<5;i++) {
			fact=fact*i;
		}
		
		return fact;
	}

}
