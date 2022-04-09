package com.learning.dsa.queues;

public class StackUsingArray {

	String stack[];
	int lenght=0;
	Integer top;
	StackUsingArray(int length){
		stack=new String[length];
		this.lenght=length;
	}
	
	protected String push(String value) {
		if(this.top==null) {
			top=0;
			stack[top]=value;
			return value;
		}
		this.stack[++this.top]=value;
		return value;
	}
	
	protected String pop() {
		if(this.isEmpty())
			return null;
		if(this.top==0) {
			this.top=null;
			return this.stack[0];
		}
		
		this.top--;
		return this.stack[this.top];
	}
	
	protected String peek() {
		return this.top==null?"No data found" : stack[this.top];
	}
	
	protected boolean isEmpty() {
		return this.top==null;
	}
}
