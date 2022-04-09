package com.learning.dsa.arrays;

public class LogAllPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[] {1,2,3,4,5};
		logAllPairs(arr);
	}

	public static void logAllPairs(int[] input) {
		for(int i=0;i<input.length;i++) { //0(n)
			for(int j=0;j<input.length;j++) {
				System.out.println(input[i]+","+input[j]);
			}
		}
		
	}
}
