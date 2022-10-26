package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4949 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) break;
			
			ArStack stack1 = new ArStack(100);
			String rs = "yes";
			
			loop :
			for (int i = 0; i < str.length(); i++) {
				
				switch (str.charAt(i)) {
				case '(' :
					stack1.push(1);
					break;
				case ')' :
					if(stack1.isEmpty()||stack1.peek()!=1) {
						rs="no";
						break loop;
					}
					stack1.pop();
					break;
				case '[' :
					stack1.push(2);
					break;
				case ']' :
					if(stack1.isEmpty()||stack1.peek()!=2) {
						rs="no";
						break loop;
					}
					stack1.pop();
					break;
				}
			}
			if(!stack1.isEmpty()) rs="no";
			
			sb.append(rs+"\n");
		}
		
		System.out.println(sb.toString());			
	}
}

class ArStack {
	
	private int top;
	private int stackSize;
	private int[] stackArr;
	
	public ArStack(int stackSize) {
		this.stackSize = stackSize;
		this.top = -1;
		this.stackArr = new int[stackSize];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (stackSize-1 == top);
	}
	
	public void push (int num) {
		if(isFull()) {
			System.out.println("다 찼습니다.");
		}else {
			stackArr[++top] = num;
		}
	}
	
	public int peek () {
		if(isEmpty()) {
			return -1;
		} else {
			return stackArr[top];			
		}
	}
	
	public int pop () {
		if(isEmpty()) {
			System.out.println("비었습니다.");
			return 0;
		} else {
			return stackArr[top--];
		}
	}
	
	public void clear() {
		if(isEmpty()) {
			return;
		} else {
			top = -1;
			stackArr = new int[this.stackSize];
		}
	}
}
