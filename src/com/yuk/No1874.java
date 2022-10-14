package com.yuk;

import java.util.Scanner;

public class No1874 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		Stack stack1 = new Stack(n);
		
		Stack stack2 = new Stack(n);
		for (int i = n; i > 0; i--) {
			stack2.push(i);
		}
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}		
		
		// n n-1 사이에는 n-1 보다 낮은 수가 나올 수 없다. 
		for (int i = 0; i < n-2; i++) {
			if(arr[i] == arr[i+2]+1 && arr[i+1] <arr[i+2]) {
				System.out.println("NO");
				return;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
		System.out.println("정렬 포문");
			while(stack1.peek() != arr[i]) {
				if(arr[i] > stack1.peek()) {
					stack1.push(stack2.pop());
					System.out.println("+");
				} else if(arr[i] < stack1.peek()) {
					stack2.push(stack1.pop());
					System.out.println("-");
				}
			}
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
			return 0;
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