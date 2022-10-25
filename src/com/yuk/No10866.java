package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class No10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque deque = new Deque();
		
		while(N-- > 0 ) {
			String[] strArr = br.readLine().split(" "); 
			switch (strArr[0]) {
			case "push_front" :
				deque.push_front(Integer.parseInt(strArr[1]));
				break;
			case "push_back" :
				deque.push_back(Integer.parseInt(strArr[1]));
				break;
			case "pop_front" :
				sb.append( deque.pop_front() + "\n");
				break;
			case "pop_back" :
				sb.append( deque.pop_back() + "\n");
				break;
			case "size" :
				sb.append(deque.size() + "\n");
				break;
			case "empty" :
				sb.append(deque.empty() + "\n");
				break;
			case "front" :
				sb.append(deque.front() + "\n");
				break;
			case "back" :
				sb.append(deque.back() + "\n");
				break;
			}
			
		}
		
		System.out.println(sb.toString());

	}

}

class Deque {
	int front;
	int back;
	int DequeSize;
	int[] dequeArr;
	
	public Deque() {
		front = back = 10000;
		DequeSize = 20000;
		dequeArr = new int[DequeSize];
	}
	
	public int size() {
		return back - front;
	}
	
	public int empty() {
		if(size() == 0) return 1;
		return 0;
	}
	
	public int front() {
		if(size() == 0) return -1;
		return dequeArr[front];
	}
	
	public int back() {
		if(size() == 0) return -1;
		return dequeArr[back-1];
	}
	
	public void push_front(int value) {
		dequeArr[--front] = value;
	}
	
	public void push_back(int value) {
		dequeArr[back++] = value;
	}
	
	public int pop_front() {
		if(empty()==1) return -1;
		return dequeArr[front++];
	}
	
	public int pop_back() {
		if(empty()==1) return -1;
		return dequeArr[--back];
	}
	
}