package com.learning.dsa.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {5,1,4,2,8};
		for(int x:insertionSort(array)) {
			System.out.print(x);
		}

	}

	public static int[] insertionSort(int[] array) {
		//Start from beginning of array index 1 and compare with previous elements, if previous elements are greater that current element the shift the previous elements one position ahead 
		//If array is already partially sorted/nearly sorted, Time Complexity - (n), worst case - O(n^2)
		for (int i = 1; i < array.length-1; i++) {
			int value=array[i];
			int j=i-1;
			/* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
			while(j>=0 && array[j]>value) {
				array[j+1]=array[j];
				j=j-1;
			}
			array[j+1]=value;
		}

		return array;
	}
}
