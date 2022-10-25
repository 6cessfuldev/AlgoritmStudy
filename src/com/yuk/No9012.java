package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9012 {

	public static String verify(String str) {
		
		ArrayStack stack = new ArrayStack();
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) =='(') {
				stack.push(1);
			} else if(str.charAt(i) == ')') {
				if(stack.pop() == -1) return "NO";
			}
		}
		if(!stack.isEmpty()) return "NO";
		return "YES";
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		while(N-->0) {
			sb.append(verify(br.readLine()) + "\n");
		}
		
		System.out.println(sb.toString());
		
	}

}

class ArrayStack {
	
	int top;
	int stackSize = 50;
	int[] stackArr;
	
	public ArrayStack() {
		top = -1;
		stackArr = new int[this.stackSize];
	}
	
	public boolean isEmpty() {
		if(top == -1) return true;
		return false;
	}
	
	public boolean isFull() {
		if(top == stackSize-1) return true;
		return false;
	}
	
	public void push(int value) {
	
		if(isFull()) {
			return;
		}
		stackArr[++top] = value;
	}
	
	public int pop() {
		if(isEmpty()) {
			return -1;
		}
		return stackArr[top--];
	}
	
	public int peek() {
		if(isEmpty()) return -1;
		return stackArr[top];
	}
	
	
}
