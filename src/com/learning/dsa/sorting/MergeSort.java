package com.learning.dsa.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] array= {5,1,4,2,8,3,3};
		for(int x:mergeSort(array)) {
			System.out.print(x);
		}
	}
	
	//Use recursion/divide & conquer
	public static int[] mergeSort(int[] array) {
		
		if(array.length==1) {
			return array;
		}
		//find middle length of an array
		int divideLenght=array.length/2;
		int[] leftArray=new int[divideLenght];
		int[] rightArray=new int[array.length-divideLenght];
		int leftArrIndex=0;
		int rightArrIndex=0;
		for(int i=0;i<array.length;i++) {
			//Insert element before middle length to left array
			if(i<divideLenght) {
				leftArray[leftArrIndex]=array[i];
				leftArrIndex++;
			}else {
			//Insert elements after middle length to right array
				rightArray[rightArrIndex]=array[i];
				rightArrIndex++;
			}
		}
		return merge(mergeSort(leftArray),mergeSort(rightArray));
	}
	
	public static int[] merge(int[] leftArray,int[] rightArray){
		int length=leftArray.length+rightArray.length;
		int[] tempArray=new int[leftArray.length+rightArray.length];
		if(leftArray.length==0)
			return rightArray;
		else if(rightArray.length==0)
			return leftArray;
		else {
			int pointer1=0;
			int pointer2=0;
			for(int i=0;i<length;i++) {
				if(pointer1==leftArray.length) {
					tempArray[i]=rightArray[pointer2];
					pointer2++;
				}else if(pointer2==rightArray.length) {
					tempArray[i]=leftArray[pointer1];
					pointer1++;
				}else if(leftArray[pointer1]<rightArray[pointer2]) {
					tempArray[i]=leftArray[pointer1];
					pointer1++;
				}else{
					tempArray[i]=rightArray[pointer2];
					pointer2++;
				}
			}
		}
		
		return tempArray;
	}
}
