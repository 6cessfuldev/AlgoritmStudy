package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		ArrStack stack = new ArrStack();
		
		while(N-- >0) {
			String[] strArr = br.readLine().split(" ");
			switch (strArr[0]) {
			case "push" :
				stack.push(Integer.parseInt(strArr[1]));
				break;
			case "pop" :
				sb.append( stack.pop() + "\n");
				break;
			case "size" :
				sb.append(stack.size() + "\n");
				break;
			case "empty" :
				sb.append(stack.isEmpty() + "\n");
				break;
			case "top" :
				sb.append(stack.peek() + "\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}

class ArrStack {
	
	int top;
	int stackSize = 10000;
	int[] stackArr;
	
	public ArrStack() {
		top = -1;
		stackArr = new int[this.stackSize];
	}
	
	public int isEmpty() {
		if(top == -1) return 1;
		return 0;
	}
	
	public boolean isFull() {
		if(top == stackSize-1) return true;
		return false;
	}
	
	public int size() {
		return top+1;
	}
	
	public void push(int value) {
	
		if(isFull()) {
			return;
		}
		stackArr[++top] = value;
	}
	
	public int pop() {
		if(isEmpty()==1) {
			return -1;
		}
		return stackArr[top--];
	}
	
	public int peek() {
		if(isEmpty()==1) return -1;
		return stackArr[top];
	}
}
