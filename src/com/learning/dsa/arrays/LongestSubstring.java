package com.learning.dsa.arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
	//Given a string s, find the length of the longest substring without repeating characters.
	//Input: s = "abcabcbb" , pwwkew , testuix
	//Output: 3 
	//Explanation: The answer is "abc", with the length of 3.
	
	public static void main(String[] args) {
		System.out.println(findSubstringLength("abcabcbb"));
		
	}
	
	/*public static int findSubstringLength(String s) {
		Hashtable<Character,Integer> ht=new Hashtable<Character,Integer>();
		int count=0;
		for(int i=0;i<s.length();i++) {
			if(ht.containsKey(s.charAt(i))) {
				int substringLength=ht.size();
				if(substringLength>count)
					count=substringLength;
				ht=new Hashtable<Character,Integer>();
			}
			ht.put(s.charAt(i), i);
		}
		return count;
	}*/
	
	public static int findSubstringLength(String s) {
		//Hashtable<Character,Integer> ht=new Hashtable<Character,Integer>();
		Map<Character, Integer> ht = new HashMap<>();
		int ans=0,startIndex=0;
		for(int i=0;i<s.length();i++) {
			if(ht.containsKey(s.charAt(i))) {
				startIndex=Math.max(startIndex,ht.get(s.charAt(i)));
				//startIndex=ht.get(s.charAt(i))+1;
			}
			
			ans=Math.max(ans, i-startIndex+1);
			ht.put(s.charAt(i), i+1);
		}
		return ans;
	}
}
