package com.learning.dsa.linkedlist;

class DoublyLinkedListNode{
	//A node in a linked list has value and a pointer to next node 
	String value;
	DoublyLinkedListNode prevNode;
	DoublyLinkedListNode nextNode;
	DoublyLinkedListNode(String value){
		//When creating a linked list, we have only one head node with a value and pointer to null as there is no next node
		this.value=value;
		this.prevNode=null;
		this.nextNode=null; 
	}
}

class CustomDoublyLinkedList{
	//A Doubly linked list has head node, tail node, length
	DoublyLinkedListNode head;
	DoublyLinkedListNode tail;
	int lenght;
	CustomDoublyLinkedList(String s){
		//When creating a doubly linked list, we have only one head node with a value and pointer to null as there is no next node/prev node
		this.head=new DoublyLinkedListNode(s);
		this.tail=this.head;  //In a linked list, we have one tail node. Which is same as head node if only one element is added in the list
		this.lenght=1;
	}
	
	protected void append(String s) {
		DoublyLinkedListNode newNode= new DoublyLinkedListNode(s);
		newNode.prevNode=this.tail;
		this.tail.nextNode=newNode; //Set the next node of current tail node (end node) to new node
		this.tail=newNode; //Set the tail node to New Node
		this.lenght++; //Increase the length
	}
	
	protected void prepend(String s) { //Add a node at the beginning of the list
		DoublyLinkedListNode newNode= new DoublyLinkedListNode(s); //Create a new node to add in the list
		this.head.prevNode=newNode;
		newNode.nextNode=this.head;
		this.head=newNode; // set the next node of head to previous head node
		this.lenght++; //Increase the length
	}
	
	protected void insert(int index,String s) {
		if(index==0)
			prepend(s);
		else if(index>=this.lenght) {
			append(s);
		}else {
			DoublyLinkedListNode newNode = new DoublyLinkedListNode(s);
			DoublyLinkedListNode leaderNode=traverseToIndex(index);
			newNode.nextNode=leaderNode.nextNode;
			leaderNode.nextNode.prevNode=newNode;
			newNode.prevNode=leaderNode;
			leaderNode.nextNode=newNode;
			this.lenght++;
		}
	}
	
	protected void delete(int index) {
		if(index==0) {
			this.head=this.head.nextNode;
			this.head.prevNode=null;
		}else {
			DoublyLinkedListNode leaderNode=traverseToIndex(index);
			if(index>=this.lenght)
				leaderNode.nextNode=null;
			else {
				DoublyLinkedListNode nodeToDelete=leaderNode.nextNode;
				leaderNode.nextNode=nodeToDelete.nextNode;
				nodeToDelete.nextNode.prevNode=leaderNode;
			}
		}
		this.lenght--;
	}
	
	protected DoublyLinkedListNode traverseToIndex(int index) {
		if(index>this.lenght-1)
			index=this.lenght-1;
		
		DoublyLinkedListNode leaderNode=this.head; // 4 -- 5 --6
		int count=1;
		while(count<index) {
			leaderNode=leaderNode.nextNode;
			count++;
		}
		return leaderNode;
	}
	
	protected DoublyLinkedListNode reverseTraverseToIndex(int index) {
		//Return the node that is after index
		if(index<0)
			index=0;
		
		DoublyLinkedListNode leaderNode=this.tail; //Start from tail node for reverse traversing
		int count=this.lenght-1; 
		while(count>=index) {
			leaderNode=leaderNode.prevNode;
			count--;
		}
		return leaderNode;
	}
	
	protected String[] get() {
		String[] allNodes=new String[this.lenght];
		int count=0;
		DoublyLinkedListNode currentNode=this.head; //Start from head node
		while(currentNode!=null) {
			allNodes[count]=currentNode.value;  //Get the value in current node
			currentNode=currentNode.nextNode;   //Set the next node to current node
			count++;
		}
		return allNodes;
	}
	
	protected String[] reverseGet() {
		String[] allNodes=new String[this.lenght];
		int count=0;
		DoublyLinkedListNode currentNode=this.tail; //Start from last node
		while(currentNode!=null) {
			allNodes[count]=currentNode.value; // Get the value in last node
			currentNode=currentNode.prevNode;  //Change the current node to previous node i.e. reverse printing
			count++;
		}
		return allNodes;
	}
	
	protected void reverse() {
		if(this.head.nextNode!=null) {
			DoublyLinkedListNode currentNode = this.tail; // Start from last node
			this.head = currentNode;
			while (currentNode != null) {
				currentNode.nextNode = currentNode.prevNode;
				currentNode.prevNode = currentNode.nextNode;
				currentNode = currentNode.prevNode;
			}
		}
		//return allNodes;
	}
	
	protected void reverse1() {
		if(this.head.nextNode!=null) {
			DoublyLinkedListNode firstNode = this.head;
			DoublyLinkedListNode secondNode=firstNode.nextNode;
			this.tail = firstNode;
			//4 -- 5 -- 6
			while (secondNode != null) {
				DoublyLinkedListNode temp= secondNode.nextNode;
				firstNode.prevNode=secondNode;
				secondNode.nextNode=firstNode;
				firstNode=secondNode;
				secondNode = temp;
			}
			this.head=firstNode;
			this.tail.nextNode=null;
			
		}
		//return allNodes;
	}
	
	protected String get(int index) {
		if(index>=this.lenght)
			return "Not found";
		
		int count=0;
		DoublyLinkedListNode currentNode=this.head;
		while(count<index) {
			currentNode=currentNode.nextNode;
			count++;
		}
		return currentNode.value;
	}
}

public class CustomDoublyLinkedListImpl {

	public static void main(String[] args) {
		CustomDoublyLinkedList myList=new CustomDoublyLinkedList("First Node");
		//myList.insert(0,"Start Node");
		 myList.append("Second Node");
		 myList.append("Third Node");
		 myList.insert(10,"End Node");
		 myList.prepend("Start Node");
		//myList.insert(2, "New Node2");
		//myList.insert(5, "End Node");
		//myList.insert(6, "Final Node");
		//myList.insert(0, "Start Node");
		
		//myList.prepend("Very First Node");
		
		/*for(String s: myList.reverseGet()) {
			System.out.println(s);
		}*/
		myList.reverse1();
		
		for(String s: myList.get()) {
			System.out.println(s);
		}
	}

}
