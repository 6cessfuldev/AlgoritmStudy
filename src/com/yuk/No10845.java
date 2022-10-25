package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		ArrQueue queue = new ArrQueue();
		
		while(N-- >0) {
			String[] strArr = br.readLine().split(" ");
			switch (strArr[0]) {
			case "push" :
				queue.push(Integer.parseInt(strArr[1]));
				break;
			case "pop" :
				sb.append( queue.pop() + "\n");
				break;
			case "size" :
				sb.append(queue.size() + "\n");
				break;
			case "empty" :
				sb.append(queue.queueIsEmpty() + "\n");
				break;
			case "front" :
				sb.append(queue.peek() + "\n");
				break;
			case "back" :
				sb.append(queue.back() + "\n");
				break;
			}
		}
		
		System.out.println(sb.toString());

	}

}

class ArrQueue {
	
	int max = 10000;
	int front; //머리
	int rear; //꼬리
	int[] queue;
	
	public ArrQueue() {
		front = rear = 0;
		queue = new int[max];
	}
	
	public int queueIsEmpty() {
		if(front == rear) {
			return 1;
		}
		return 0;
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
			return;
		}
		queue[rear++] = value;
	}
	
	public int pop() {
		if(queueIsEmpty()==1) {
			return -1;
		}
		int popValue = queue[front++];
		return popValue;
	}
	
	public int peek() {
		if(queueIsEmpty()==1) {
			return -1;
		} 
		int popValue = queue[front];
		return popValue;
	}
	
	public int back() {
		if(queueIsEmpty()==1) {
			return -1;
		}
		return queue[rear-1];
	}
}