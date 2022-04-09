package com.learning.dsa.recursion;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for(int i:fibonacci(5)) {
			System.out.println(fibonacci(3));
		//}
	}
	
	
	public static int fibonacci(int num) {
		int arr[]=new int[num+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<=num;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[num];
		
	}
}
