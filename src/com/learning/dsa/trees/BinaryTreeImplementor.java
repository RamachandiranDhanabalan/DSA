package com.learning.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
	
	int value; //Value of current node
	Node left; //Pointer to left node
	Node right; //Pointer to right node
	Node(){
		this.value=0;
		this.left=null;
		this.right=null;
	}
	
	Node(int value){
		this.value=value;
		this.left=null;
		this.right=null;
	}
}

class BinarySearchTree{
	
	Node root;
	BinarySearchTree(){
		root=null;
	}
	
	public int insert(int value) {
		Node newNode=new Node(value);
		int height=0;
		if(root==null) {
			this.root=newNode;
		}else {
			Node parent=this.root;
			while(parent!=null) {
				if(value<parent.value) {
					if(parent.left==null) {
						parent.left=newNode;
						return height;
					}else
						parent=parent.left;
				}else {
					if(parent.right==null) {
						parent.right=newNode;
						parent=newNode;
						return height;
					}else
						parent=parent.right;
				}
				height++;
			}
			
		}
		return height;
	}
	
	public String lookup(int value) {
		int height=0;
		if(root==null) {
			return "Element "+value+" Not found";
		}
		if(root.value==value) {
			return "Element "+value+" found at level "+0;
		}
	
		Node parent = this.root;
		while (parent != null) {
			if(parent.value==value) {
				return "Element "+value+" found at level "+height;
			}
			if (value < parent.value) {
				if (parent.left == null) {
					return "Element "+value+" Not found";
				} else
					parent = parent.left;
			} else {
				if (parent.right == null) {
					return "Element "+value+" Not found";
				} else
					parent = parent.right;
			}
			height++;
		}

		return "Element "+value+" Not found";
	}
	
	public int delete(int value) {
		if(root==null) {
			return 0;
		}else {
			Node parentNode=this.root;
			Node nodeToDelete=this.root;
			while(nodeToDelete!=null) {
				if(value<nodeToDelete.value) {
					if(nodeToDelete.left==null) {
						return 0;
					}else {
						parentNode=nodeToDelete;
						nodeToDelete=nodeToDelete.left;
					}
				} else if(value>nodeToDelete.value) {
						if(nodeToDelete.right==null) {
							return 0;
						}else {
							parentNode=nodeToDelete;
							nodeToDelete=nodeToDelete.right;
						}
				}else if(value==nodeToDelete.value) {
					if(nodeToDelete.right!=null) {
						Node nextNodeOfGivenValue=nodeToDelete.right;
						Node prevNode=nodeToDelete.right;
						Node nodeToReplace=nextNodeOfGivenValue;
						while(nodeToReplace.left!=null) {
							prevNode=nodeToReplace;
							nodeToReplace=nodeToReplace.left;
						}
						nodeToReplace.right=nextNodeOfGivenValue;
						nodeToReplace.left=nodeToDelete.left;
						parentNode.right=nodeToReplace;
						prevNode.left=null;
					}else
						parentNode.left=nodeToDelete.left;	
				
					return 1;
				}
			}
			
		}
		return 0;
	}
	
	public void breadthFirstSearch() {
		Node currentNode=this.root;
		Queue<Node> myQueue= new LinkedList<Node>();
		List<Integer> nodeList=new ArrayList<Integer>();
		myQueue.add(currentNode);
		while(myQueue.peek()!=null) {
			currentNode=myQueue.peek();
			nodeList.add(currentNode.value);
			if(currentNode.left!=null)
				myQueue.add(currentNode.left);
			
			if(currentNode.right!=null)
				myQueue.add(currentNode.right);
			myQueue.poll();
		}
		
		for(int x:nodeList) {
			System.out.print(x+" ");
		}
	}
	
	public void breadthFirstSearchByRecursion() {
		Node currentNode=this.root;
		Queue<Node> myQueue= new LinkedList<Node>();
		List<Integer> nodeList=new ArrayList<Integer>();
		myQueue.add(currentNode);
		nodeList=bfsByRecursion(myQueue,nodeList);
		/*while(myQueue.peek()!=null) {
			currentNode=myQueue.peek();
			nodeList.add(currentNode.value);
			if(currentNode.left!=null)
				myQueue.add(currentNode.left);
			
			if(currentNode.right!=null)
				myQueue.add(currentNode.right);
			myQueue.poll();
		}*/
		
		for(int x:nodeList) {
			System.out.print(x+" ");
		}
	}
	
	public List<Integer> bfsByRecursion(Queue<Node> myQueue,List<Integer> nodeList) {
		if(myQueue.isEmpty()) {
			return nodeList;
		}
		
		Node currentNode=myQueue.poll();
		nodeList.add(currentNode.value);
		if(currentNode.left!=null)
			myQueue.add(currentNode.left);
		
		if(currentNode.right!=null)
			myQueue.add(currentNode.right);
		
		return bfsByRecursion(myQueue,nodeList);
	}
	
	public void dfsInOrder() {
		for(int x:dfsInOrderUsingRecursion(this.root,new ArrayList<Integer>())) {
			System.out.print(x+" ");
		}
	}
	
	public void dfsPreOrder() {
		System.out.println();
		for(int x:dfsPreOrderUsingRecursion(this.root,new ArrayList<Integer>())) {
			System.out.print(x+" ");
		}
	}
	
	public void dfsPostOrder() {
		System.out.println();
		for(int x:dfsPostOrderUsingRecursion(this.root,new ArrayList<Integer>())) {
			System.out.print(x+" ");
		}
	}
	
	public List<Integer> dfsInOrderUsingRecursion(Node node,ArrayList<Integer> list) {
		//InOrder start from adding left most node value first and traverse to parent and then to right node
		//Hence push value after traversing left nodes
		if(node.left!=null)
			list.addAll(dfsInOrderUsingRecursion(node.left,new ArrayList<Integer>()));
		list.add(node.value);
		if(node.right!=null)
			list.addAll(dfsInOrderUsingRecursion(node.right,new ArrayList<Integer>()));
		//list.add(node.value);
		return list;
	}
	
	public List<Integer> dfsPreOrderUsingRecursion(Node node,ArrayList<Integer> list) {
		//PreOrder start from adding current node value first and traverse the left/right node 
		//Hence push value first and then traverse right/left node
		list.add(node.value);
		if(node.left!=null)
			list.addAll(dfsPreOrderUsingRecursion(node.left,new ArrayList<Integer>()));
		
		if(node.right!=null)
			list.addAll(dfsPreOrderUsingRecursion(node.right,new ArrayList<Integer>()));
		return list;
	}
	
	public List<Integer> dfsPostOrderUsingRecursion(Node node,ArrayList<Integer> list) {
		//PostOrder add node value only of it's left and right node values are added already
		//Hence push value after traversing left/right node first
		if(node.left!=null)
			list.addAll(dfsPostOrderUsingRecursion(node.left,new ArrayList<Integer>()));
		
		if(node.right!=null)
			list.addAll(dfsPostOrderUsingRecursion(node.right,new ArrayList<Integer>()));
		
		list.add(node.value);
		return list;
	}
	
}

public class BinaryTreeImplementor {
	
	public static void main(String[] args) {
		BinarySearchTree bt=new BinarySearchTree();
		bt.insert(9);
		bt.insert(4);
		bt.insert(6);
		bt.insert(20);
		bt.insert(170);
		bt.insert(15);
		bt.insert(1);
		//bt.insert(160);
		
		//bt.breadthFirstSearch();
		bt.dfsInOrder();
		bt.dfsPreOrder();
		bt.dfsPostOrder();
	}
	
}
