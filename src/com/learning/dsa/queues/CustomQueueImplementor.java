package com.learning.dsa.queues;

class QueueNode{
	String value;
	QueueNode next;
	QueueNode(){
		value=null;
		next=null;
	}
	
	QueueNode(String value){
		this.value=value;
		next=null;
	}
}
class CustomQueue{
	QueueNode first=null;
	QueueNode last =null;
	int lenght=0;
	CustomQueue(){
	}
	
	public int enqueue(String value) {
		QueueNode newNode=new QueueNode(value);
		if(this.first==null) {
			this.first=newNode;
			this.last=newNode;
		}else {
			//this.first.next=newNode;
			this.last.next=newNode;
			this.last=newNode;
		}
		this.lenght++;
		return this.lenght;
	}
	
	public int dequeue() {
		if(this.first==null) {
			return 0;
		}
		if(this.first==this.last) {
			this.first=this.last=null;
		}else {
			this.first=this.first.next;
		}
		this.lenght--;
		return this.lenght;
	}
	
	public String peek() {
		if(this.first==null) {
			return "No entry found";
		}
		return this.first.value;
	}
}
public class CustomQueueImplementor {

	public static void main(String[] args) {
		CustomQueue myQueue=new CustomQueue();
		myQueue.enqueue("Ana");
		myQueue.enqueue("Bala");
		myQueue.enqueue("Catherin");
		myQueue.dequeue();
		myQueue.dequeue();
		//myQueue.dequeue();
		
		System.out.println(myQueue.peek());

	}

}
