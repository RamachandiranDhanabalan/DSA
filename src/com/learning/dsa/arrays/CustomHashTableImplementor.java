package com.learning.dsa.arrays;
import java.util.ArrayList;

class KeyValue {
	String key;
	String value;
	KeyValue(String key,String value){
		this.key=key;
		this.value=value;
	}
}


class CustomHashTable{
	int size=0;
	ArrayList<KeyValue>[] array;
	
	CustomHashTable(){
	}
	
	CustomHashTable(int size){
		this.size=size;
		//array=new String[size];
		array=new ArrayList[size];
	}
	
	private int getHash(String key) {
		int hash=0;
		for(int i=0;i<key.length();i++) {
			hash=(hash+(int)key.charAt(i)*i)%size;
		}
		return hash;
	}
	
	protected int put(String key,String Value) {
		int hash=getHash(key);
		if(array[hash]==null) {
			ArrayList<KeyValue> temp=new ArrayList<KeyValue>();
			//temp.add(new KeyValue(key,Value));
			array[hash]=temp;
		}
		array[hash].add(new KeyValue(key,Value));
		//this.array[hash]=Value;
		return hash;
	}
	
	protected String get(String key) {
		int hash=getHash(key);
		if(this.array[hash]==null)
			return "Key not found!";
		
		for(KeyValue x:this.array[hash]) {
			if(x.key.equals(key))
				return x.value;
		}
		//KeyValue keyPair=this.array[hash];
		return null;
	}
	
	protected String[] getKeys() {
		int totalKeys=this.array.length;
		String[] keys=new String[totalKeys];
		int count=0;
		for(ArrayList<KeyValue> x:this.array) {
			if(x!=null) {
				for(KeyValue y:x) {
					if(y!=null)
						keys[count]=y.key;
					count++;
				}
			}
			
		}
		return keys;
	}
}

public class CustomHashTableImplementor extends CustomHashTable {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CustomHashTable ht = new CustomHashTable(10);
		System.out.println(ht.put("Hello","1"));
		System.out.println(ht.put("Hello1","Welcome!"));
		System.out.println(ht.put("Hello","Welcome!"));
		
		System.out.println(ht.get("Hello"));
		System.out.println(ht.get("Hello1"));
		System.out.println(ht.getKeys());
		for(String str: ht.getKeys()) {
			System.out.println(str);
		}
	}
}