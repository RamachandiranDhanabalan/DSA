package com.learning.dsa.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array= {5,1,4,2,8};
		for(int x:bubbleSort(array)) {
			System.out.print(x);
		}
	}
	
	public static int[] bubbleSort(int[] array) {
		int temp = 0;
		//Compares adjacent numbers repeatedly  until the array is sorted
		// 5 1 4 2 8
		//Pass 1 - Input : 5 1 4 2 8
		//Compare 5 1 -> ( Swap 5 ,1 since 5 > 1) -> 1 5 4 2 8 
		//Compare 5 4 -> ( Swap 5 ,4 since 5 > 1) -> 1 4 5 2 8 
		//Compare 5 2 -> ( Swap 5 ,2 since 5 > 2) -> 1 4 2 5 8
		//Compare 5 8 -> ( No Swap) -> 1 4 2 5  8
		//Pass 2 - Input : 1 4 2 5 8
		//Compare 1 4 -> (No Swap) -> 1 4 2 5 8 
		//Compare 4 2 -> (Swap 4 ,2 since 4 > 2) -> 1 2 4 5 8 
		//Compare 4 5 -> (No Swap) -> 1 2 4 5 8 
		//Compare 5 8 -> (No Swap) ->1 2 4 5 8 
		//Continue Pass till end of element
		
		//Time Complexity - O(n^2); Space Complexity - O(1)
		
		for (int i = 0; i < array.length; i++) {
			
			//Compares adjacent numbers
			for (int j = 0; j < array.length-1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}
