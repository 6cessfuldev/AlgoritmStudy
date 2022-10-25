package com.yuk;

import java.util.Scanner;

public class No1874 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = scan.nextInt();	
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		Stack stack1 = new Stack(n);
		
		int num = 1;
		int cnt = 0;
		
		boolean flag = true;
		while(cnt<n) {
			if(stack1.peek()==arr[cnt]) {
				stack1.pop();
				cnt++;
				sb.append("-\n");
			} else if(arr[cnt] > stack1.peek()) {
				stack1.push(num++);
				sb.append("+\n");
			} else {
				flag = false;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("NO");
		} else {
			System.out.println(sb.toString());
		}
	}
}

class Stack {
	
	private int top;
	private int stackSize;
	private int[] stackArr;
	
	public Stack(int stackSize) {
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