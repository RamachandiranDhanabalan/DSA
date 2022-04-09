package com.learning.dsa.stacks;

class ArrayStack{
	String stack[];
	int lenght=0;
	Integer top;
	ArrayStack(int length){
		stack=new String[length];
		this.lenght=length;
	}
	
	protected int push(String value) {
		if(this.top==null) {
			stack[top=0]=value;
			return this.top;
		}
		this.stack[++this.top]=value;
		return this.top;
	}
	
	protected int pop() {
		if(this.isEmpty())
			return 0;
		if(this.top==0) {
			this.top=null;
			return 0;
		}
		
		this.top--;
		return this.top;
	}
	
	protected String peek() {
		return this.top==null?"No data found" : stack[this.top];
	}
	
	protected boolean isEmpty() {
		return this.top==null;
	}
}


public class CustomStackImplementorUsingArray {

	public static void main(String[] args) {
		ArrayStack s1=new ArrayStack(10);
		s1.push("Google");
		s1.push("Udemy");
		s1.push("Youtube");
		s1.pop();
		s1.pop();
		
		System.out.println(s1.peek());
	}

}
