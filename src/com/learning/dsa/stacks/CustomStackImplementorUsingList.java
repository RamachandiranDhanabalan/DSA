package com.learning.dsa.stacks;

class Node{
	String value;
	Node next;
	Node(){
		value=null;
		next=null;
	}
	
	Node(String s){
		value=s;
		next=null;
	}
}
class Stack{
	Node top;
	Node bottom;
	int lenght=0;
	Stack(){
		this.top=null;
		this.bottom=null;
		this.lenght++;
	}
	
	protected int push(String value) {
		Node newNode=new Node(value);
		if(this.top==null) {
			this.top=newNode;
			this.bottom=newNode;
		}else {
			newNode.next=this.top; // Assign current top as next node new top,so that top can be moved to previous top incase of pop 
			this.top.next=newNode;
			this.top=newNode;
		}
		this.lenght++;
		return this.lenght;
	}
	
	protected int pop() {
		if(this.isEmpty())
			return 0;
		if(this.top==this.bottom) {
			this.top=this.bottom=null;
			return 0;
		}
		this.top=this.top.next;
		this.lenght--;
		return this.lenght;
	}
	
	protected String peek() {
		return this.top==null?"No data found" : this.top.value;
	}
	
	protected boolean isEmpty() {
		return this.top==null;
	}
}


public class CustomStackImplementorUsingList {

	public static void main(String[] args) {
		Stack s1=new Stack();
		s1.push("Udemy");
		s1.push("Youtube");
		s1.pop();
		//s1.pop();
		
		System.out.println(s1.peek());
	}

}
