package com.learning.dsa.arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1=new int[] {0,3,4,31,35};
		int[] arr2=new int[] {4,6,30,34};
		int[] finalArray=mergeArrays(arr1,arr2);
		for(int x:finalArray) {
			System.out.print(x+" ");
		}
		
	}
	
	public static int[] mergeArrays(int[] arr1,int[] arr2) {
		int maxLenght=arr1.length+arr2.length;
		int[] mergedArray=new int[maxLenght];
		int pointer1=0;
		int pointer2=0;
		for(int i=0;i<maxLenght;i++) {
			if(pointer1==arr1.length) {
				mergedArray[i]=arr2[pointer2];
				pointer2++;
			}else if(pointer2==arr2.length){
				mergedArray[i]=arr1[pointer1];
				pointer1++;
			}else if(arr1[pointer1]<=arr2[pointer2]) {
				mergedArray[i]=arr1[pointer1];
				pointer1++;
			}else if(pointer1==arr1.length || arr1[pointer1]>arr2[pointer2]){
				mergedArray[i]=arr2[pointer2];
				pointer2++;
			}
		}
		return mergedArray;
	}

}
