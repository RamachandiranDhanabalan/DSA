package com.learning.dsa.queues;

class CustomQueueUsingStack{
	
	StackUsingArray stack1; //Original Stack
	StackUsingArray stack2; //Stack to place the elements in reverse
	String front;
	
	CustomQueueUsingStack(int length) {
		stack1=new StackUsingArray(length);
		stack2=new StackUsingArray(length);
	}
	
	protected int enqueue(String value) {
		if(stack1.isEmpty()) {
			//stack1.push(value);
			front=value;
		}
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack2.push(value);
		while(!stack2.isEmpty()) {
			stack1.push(stack2.stack[this.stack2.top]);
			stack2.pop();
		}
		return 0;
	}
	
	protected String peek() {
		return stack1.peek();
	}
	
	protected String dequeue() {
		return stack1.pop();
	}
}
public class CustomQueueImplementorUsingStack{

	public static void main(String[] args) {
		CustomQueueUsingStack queue=new CustomQueueUsingStack(10);
		queue.enqueue("google");
		queue.enqueue("Youtube");
		queue.enqueue("Udemy");
		//queue.enqueue("Welcome Page");
		
		System.out.println(queue.peek());
		queue.dequeue();
		
		System.out.println(queue.peek());
		//queue.dequeue();
		//System.out.println(queue.peek());
	}

}
