package com.learning.dsa.linkedlist;

class Node{
	//A node in a linked list has value and a pointer to next node 
	String value;
	Node nextNode;
	Node(String value){
		//When creating a linked list, we have only one head node with a value and pointer to null as there is no next node
		this.value=value;
		this.nextNode=null; 
	}
}

class CustomLinkedList{
	//A linked list has head node, tail node, length
	Node head;
	Node tail;
	int lenght;
	CustomLinkedList(String s){
		//When creating a linked list, we have only one head node with a value and pointer to null as there is no next node
		this.head=new Node(s);
		this.tail=this.head;  //In a linked list, we have one tail node. Which is same as head node if only one element is added in the list
		this.lenght=1;
	}
	
	protected void append(String s) {
		Node newNode= new Node(s);
		this.tail.nextNode=newNode; //Set the next node of current tail node (end node) to new node
		this.tail=newNode; //Set the tail node to New Node
		this.lenght++; //Increase the length
	}
	
	protected void prepend(String s) { //Add a node at the beginning of the list
		Node newNode= new Node(s); //Create a new node to add in the list
		Node currentHead=this.head;
		this.head=newNode; // set the next node of head to previous head node
		this.head.nextNode=currentHead;
		this.lenght++; //Increase the length
	}
	
	protected void insert(int index,String s) {
		if(index==0)
			prepend(s);
		else if(index>=this.lenght) {
			append(s);
		}else {
			Node newNode = new Node(s);
			Node leaderNode=traverseToIndex(index);
			newNode.nextNode=leaderNode.nextNode;
			leaderNode.nextNode=newNode;
			this.lenght++;
		}
	}
	
	protected void delete(int index) {
		if(index==0) {
			this.head=this.head.nextNode;
		}else {
			Node leaderNode=traverseToIndex(index);
			if(index>=this.lenght)
				leaderNode.nextNode=null;
			else
				leaderNode.nextNode=leaderNode.nextNode.nextNode;
		}
		this.lenght--;
	}
	
	protected Node traverseToIndex(int index) {
		if(index>this.lenght-1)
			index=this.lenght-1;
		
		Node leaderNode=this.head; // 4 -- 5 --6
		int count=1;
		while(count<index) {
			leaderNode=leaderNode.nextNode;
			count++;
		}
		return leaderNode;
	}
	
	protected String[] get() {
		String[] allNodes=new String[this.lenght];
		int count=0;
		Node currentNode=this.head;
		while(currentNode!=null) {
			Node nextNode=currentNode.nextNode;
			allNodes[count]=currentNode.value;
			currentNode=nextNode;
			count++;
		}
		return allNodes;
	}
	
	protected String get(int index) {
		if(index>=this.lenght)
			return "Not found";
		
		int count=0;
		Node currentNode=this.head;
		while(count<index) {
			currentNode=currentNode.nextNode;
			count++;
		}
		return currentNode.value;
	}
}

public class CustomLinkedListImplementor {

	public static void main(String[] args) {
		CustomLinkedList myList=new CustomLinkedList("First Node");
		//myList.insert(0,"Start Node");
		 myList.append("Second Node");
		 myList.append("Third Node");
		 myList.insert(10,"End Node");
		//myList.insert(2, "New Node2");
		//myList.insert(5, "End Node");
		//myList.insert(6, "Final Node");
		//myList.insert(0, "Start Node");
		
		//myList.prepend("Very First Node");
		
		for(String s: myList.get()) {
			System.out.println(s);
		}
		myList.delete(1);
		//myList.delete(1);
		
		for(String s: myList.get()) {
			System.out.println(s);
		}
	}

}
