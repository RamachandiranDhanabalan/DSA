package com.learning.dsa.graphs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

class Graph{
	//Implement Graph using Adjacent List method
	//Adjacent List is HashTable with key as Node values and values as a list of adjacent nodes
	//  3 -- 4 -- 5
	//	|	 |	  |
	//  1 -- 2	  6
	//  \	/
	//    0
	//In the above graph we need to store all the nodes (0,1,2,3,4,5,60) as keys and adjacent nodes in a list(1 -> 0 3 2, 2-> 4 1 0) as values 
	//Keys - Values
	//6--->5 
	//5--->4 6 
	//4--->3 2 5 
	//3--->1 4 
	//2--->4 1 0 
	//1--->3 2 0 
	//0--->1 2 
	int numberOfNodes=0;
	Hashtable<Integer,ArrayList<Integer>> adjacentList;
	Graph(){
		numberOfNodes=0;
		adjacentList=new Hashtable<Integer,ArrayList<Integer>>();
	}
	
	public boolean addVertex(int value){
		if(adjacentList.get(value)!=null)
			return false;
		
		adjacentList.put(value, new ArrayList<Integer>());
		numberOfNodes++;
		return true;
	}
	
	public boolean addEdge(int node1,int node2){
		if(this.adjacentList.get(node1)==null || this.adjacentList.get(node2)==null)
			return false;
		else {
			//Since it's undirected graph add the relationship in both nodes
			this.adjacentList.get(node1).add(node2);
			this.adjacentList.get(node2).add(node1);
		}
		return true;
	}
	
	public void showConnections(){
		Set<Integer> set= this.adjacentList.keySet();
		for(Integer i:set) {
			ArrayList<Integer> edges=this.adjacentList.get(i);
			System.out.print(i+"--->");
			for(Integer edge: edges) {
				System.out.print(edge+" ");
			}
			System.out.println();
		}
	}
}



public class GraphImplementor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph myGraph=new Graph();
		myGraph.addVertex(0);
		myGraph.addVertex(1);
		myGraph.addVertex(2);
		myGraph.addVertex(3);
		myGraph.addVertex(4);
		myGraph.addVertex(5);
		myGraph.addVertex(6);
		
		myGraph.addEdge(3, 1);
		myGraph.addEdge(3, 4); 
		myGraph.addEdge(4, 2); 
		myGraph.addEdge(4, 5); 
		myGraph.addEdge(1, 2); 
		myGraph.addEdge(1, 0); 
		myGraph.addEdge(0, 2); 
		myGraph.addEdge(6, 5);
		
		myGraph.showConnections();
		
	}

}
