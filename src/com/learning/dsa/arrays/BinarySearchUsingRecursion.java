package com.learning.dsa.arrays;
import java.util.Arrays;

public class BinarySearchUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array=new int[] {2,4,6,8,10,23,56};
		if(binarySearch(array,56)[0]==56) {
			System.out.print("Element found");
		}else {
			System.out.print("Element Not found");
		}
	}
	
	public static int[] binarySearch(int[] array,int num) {
		if(array.length==1) {
			return array;
		}
		int middleIndex=array.length/2;
		int[] newArray;
		if(num>array[middleIndex]) {
			newArray= Arrays.copyOfRange(array,middleIndex,array.length);
		}else if(num<array[middleIndex]) {
			newArray= Arrays.copyOfRange(array,0,middleIndex);
		}else {
			newArray= new int[] {array[middleIndex]};
		}
		return binarySearch(newArray,num);
	}
	
}
