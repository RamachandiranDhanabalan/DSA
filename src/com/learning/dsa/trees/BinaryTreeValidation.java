package com.learning.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreeValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode left = new TreeNode(1);
		
		TreeNode subTreeLeft = new TreeNode(4);
		TreeNode subTreeRight = new TreeNode(10);
		TreeNode right = new TreeNode(8,subTreeLeft,subTreeRight);
		TreeNode root = new TreeNode(5, left, right);
		
		
		System.out.print(isValidBST(root,null,null));
	}
	
	
	//Pass the integer range and the node value should fall between that range
	//For left nodes: maintain the lower range same as parent node and update the high value to root node value ex: Left node range : -Any Integer/Low value of parent node < Node Value < Parent Node Value
	//For right nodes: maintain the high range same as parent node and update the low value to root node value ex: Right node range : Parent Node value < Node Value < + Infinity
	public static boolean isValidBST(TreeNode root,Integer low,Integer high) {
		
		if(root==null)
			return true; //An empty tree is also a binary tree
		if(low!=null && low>=root.val)
			return false;
		if(high!=null && high<=root.val)
			return false;
		return isValidBST(root.left,low,root.val) && isValidBST(root.right,root.val,high);
	}

}
