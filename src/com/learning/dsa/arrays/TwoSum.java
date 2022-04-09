package com.learning.dsa.arrays;
import java.util.Hashtable;

public class TwoSum {
	// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	// You may assume that each input would have exactly one solution, and you may not use the same element twice.
	// You can return the answer in any order.
	
	public static int[] twoSum(int[] nums, int target) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int[] retArray = new int[2];
		for (int i = 0; i < nums.length; i++) {
			//if (nums[i] <= target) {
				Integer pairIndex = ht.get(target - nums[i]);
				if (pairIndex != null) {
					retArray[0] = i;
					retArray[1] = pairIndex;
				} else {
					ht.put(nums[i], i);
				}
			//}

		}

		return retArray;
	}
	
	public static void printArray(int[] nums) {
		for(int x:nums) {
			System.out.println(x);
		}
	}

	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		//printArray(twoSum(nums, 9));
		
		int[] nums1 = {3,2,4};
		//printArray(twoSum(nums1, 6));
		
		int[] nums2 = {0,4,3,0};
		printArray(twoSum(nums2, 0));
	}

}
