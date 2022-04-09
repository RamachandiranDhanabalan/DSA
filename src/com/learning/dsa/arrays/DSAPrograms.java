package com.learning.dsa.arrays;
import java.util.Hashtable;

public class DSAPrograms {

	public static void main(String[] args) {
		// hasCommonItem in two arrays?
		char[] arr1=new char[] {'a','b',' ','d'};
		char[] arr2=new char[] {'x','y','x','z','a'};
		char[] arr3=new char[] {'x','y','v','z'};
		System.out.println(hasCommonItem(arr1,arr2));
		System.out.println(hasCommonItem(arr1,arr3));
		
		
	}
	
	public static boolean hasCommonItem(char[] arr1,char[] arr2) {
		//Time Complexity
		//Nested loop - Quadratic time - O(a*b); a- number of inputs in arr1, b- number of inputs in arr2; 
		//Loop one after another - Linear - O(a+b) - Better time complexity than Quadratic
		//Space Complexity
		//Nested loop - Space complexity - O(1) - No new variables created 
		//Loop one after another - O(a) - Hastable used to store the number of elements(a) from array1
		Hashtable<Character,Boolean> elements=new Hashtable<Character,Boolean>(); 
		for(char arrItem:arr1) { //loop first array and insert all items into hash table
			if(null==elements.get(arrItem) || !elements.get(arrItem))
				elements.put(arrItem, true);
		}
		
		for(char arrItem:arr2) { //loop second array and check if the item present inside hash table
			if(null!=elements.get(arrItem)&&elements.get(arrItem)) {
				return true;
			}
		}
		return false;
	}
	
	/*public static boolean hasPairSumsToGivenTotal(int[] arr1) {
		//Time Complexity
		//Nested loop - Quadratic time - O(a*b); a- number of inputs in arr1, b- number of inputs in arr2; 
		//Loop one after another - Linear - O(a+b) - Better time complexity than Quadratic
		//Space Complexity
		//Nested loop - Space complexity - O(1) - No new variables created 
		//Loop one after another - O(a) - Hastable used to store the number of elements(a) from array1
		Hashtable<Character,Boolean> elements=new Hashtable<Character,Boolean>(); 
		for(char arrItem:arr1) { //loop first array and insert all items into hash table
			if(null==elements.get(arrItem) || !elements.get(arrItem))
				elements.put(arrItem, true);
		}
		
		for(char arrItem:arr2) { //loop second array and check if the item present inside hash table
			if(null!=elements.get(arrItem)&&elements.get(arrItem)) {
				return true;
			}
		}
		return false;
	}*/
}
