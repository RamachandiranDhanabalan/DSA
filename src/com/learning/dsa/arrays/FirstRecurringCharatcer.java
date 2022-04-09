package com.learning.dsa.arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharatcer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s1=new String[] {"a","b","c","d","a"};
		String[] s2=new String[] {"a","b","b","d","e"};
		String[] s3=new String[] {"a","b","c","d","e"};
		System.out.println(firstRecurrenceLetter(s1));
		System.out.println(firstRecurrenceLetter(s2));
		System.out.println(firstRecurrenceLetter(s3));
	}
	
	public static String firstRecurrenceLetter(String[] arr) {
		Map<String,Integer> hm=new HashMap<String,Integer>();
		for(String s:arr) { //time complexity - O(n);Space complexity - O(n) 
			if(hm.get(s)!=null)
				return s;
			hm.put(s, 1);
		}
		
		return "No letter found!";
	}

}
