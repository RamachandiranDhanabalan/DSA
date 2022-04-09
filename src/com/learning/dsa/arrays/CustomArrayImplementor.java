package com.learning.dsa.arrays;
class CustomArray {
	private int lenght = 0;
	private int[] data;

	CustomArray() {
		this.lenght = 0;
		data = new int[lenght];
	}

	public void push(int item) {
		int[] tempData = new int[++this.lenght];
		for (int i = 0; i < data.length; i++) {
			tempData[i] = this.data[i];
		}
		tempData[this.lenght - 1] = item;
		data = tempData;
	}

	public void pop() {
		if (this.lenght > 0)
			this.lenght--;
	}

	public void insert(int index, int item) {
		int[] tempData = new int[++this.lenght];
		int currentItem = this.data[index];
		int tempDataLenght = 0;
		for (int i = 0; i < data.length && tempDataLenght < this.lenght; i++) {
			if (i != index) {
				tempData[tempDataLenght] = data[i];
				tempDataLenght++;
			} else {
				tempData[tempDataLenght++] = item;
				tempData[tempDataLenght++] = currentItem;
			}
		}
		data = tempData;
	}

	public void delete(int index) {
		for (int i = index; i < this.lenght - 1; i++) {
			this.data[i] = this.data[i + 1];
		}
		this.lenght--;
	}

	public int get(int index) throws Exception {
		if (index > -1 && index < this.lenght)
			return this.data[index];
		else
			throw new Exception("Array Index Out of Bound Exception" + index);
	}

	public void printArray() {
		for (int i = 0; i < this.lenght; i++) {
			System.out.println(this.data[i]);
		}
	}
}

public class CustomArrayImplementor extends CustomArray {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CustomArray arr = new CustomArray();
		arr.push(5);
		arr.push(7);
		arr.push(9);
		arr.push(31);
		arr.insert(1, 10);

		CustomArray arr1 = new CustomArray();
		arr1.push(5);
		arr1.push(7);
		arr1.push(9);

		arr.printArray();
		arr1.printArray();

	}

}
