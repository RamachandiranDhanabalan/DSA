package com.learning.dsa.recursion;

public class ReverseString {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Hello";
		
		//System.out.println(s.substring(0,s.length()-1));
		System.out.println(reverse("Welcome"));
		
	}
	
	public static String reverse(String s) {
		if(s.length()<2) {
			System.out.println(s);
			return s;
		}
		
		//return s.charAt(s.length()-1)+reverse(s.substring(0,s.length()-1));
		return reverse(s.substring(1))+s.charAt(0);
	}
}
