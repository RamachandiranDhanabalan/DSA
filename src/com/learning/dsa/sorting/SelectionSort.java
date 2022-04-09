package com.learning.dsa.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {5,1,4,2,8};
		for(int x:selectionSort(array)) {
			System.out.print(x);
		}

	}

	public static int[] selectionSort(int[] array) {
		// Pass 1: Start from first element and find the smallest element by looping
		// through end of list, then swap the smallest with first index
		// Pass 2: Start from second element and find the smallest element by looping
		// through end of list, then swap the smallest with second index
		// Continue above steps until end of element is reached
		// Time Complexity - O(n^2); Space Complexity - O(1)
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			int smallIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[smallIndex] > array[j]) {
					//small = array[j];
					smallIndex = j;
				}
			}
			array[i] = array[smallIndex];
			array[smallIndex] = temp;
		}

		return array;
	}
}
