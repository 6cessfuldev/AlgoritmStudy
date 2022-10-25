package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class No2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayQueue queue = new ArrayQueue();
		
		for (int i = 1; i <= N; i++) {	
			queue.push(i);
		}
		
		while(true) {
			if(queue.size()==1) break;
			queue.pop();
			queue.push(queue.pop());
		}
	
		System.out.println(queue.pop());
	}

}

class ArrayQueue {
	
	int max = 1000000;
	int front; //머리
	int rear; //꼬리
	int[] queue;
	
	public ArrayQueue() {
		front = rear = 0;
		queue = new int[max];
	}
	
	public boolean queueIsEmpty() {
		return front == rear;
	}
	
	public boolean queueIsFull() {
		if(rear == max) {
			return true;
		}else {
			return false;
		}
	}
	
	public int size() {
		return rear-front;
	}
	
	public void push(int value) {
		if(queueIsFull()) {
			System.out.println("큐가 다 찼습니다.");
			return;
		}
		queue[rear++] = value;
	}
	
	public int pop() {
		if(queueIsEmpty()) {
			System.out.println("큐가 비었습니다.");
			return -1;
		}
		int popValue = queue[front++];
		return popValue;
	}
	
	public int peek() {
		if(queueIsEmpty()) {
			System.out.println("큐가 비었습니다.");
			return -1;
		} 
		int popValue = queue[front];
		return popValue;
	}
}