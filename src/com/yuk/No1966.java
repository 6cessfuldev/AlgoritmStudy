package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int c = Integer.parseInt(br.readLine());

		while(c-- > 0) {
			String[] strArr = br.readLine().split(" ");
			int n = Integer.parseInt(strArr[0]);
			int m = Integer.parseInt(strArr[1]);
			
			String[] strArr2 = br.readLine().split(" ");
			
			ArQueue queue1 = new ArQueue(n*n);
			ArQueue queue2 = new ArQueue(n*n);
			for (int i = 0; i < n; i++) {
				queue1.push(Integer.parseInt(strArr2[i]));
				queue2.push(i);
			}
			
			int cnt = 1;			
			while(!queue1.isEmpty()) {
				boolean flag = true;
				for (int i = queue1.front+1; i<queue1.back; i++) {
					if(queue1.peek()<queue1.queueArr[i]) {
						queue1.push(queue1.pop());
						queue2.push(queue2.pop());
						flag = false;
						break;
					}
				}
				if(flag) {
					if(queue2.peek()==m) {
					 break;	
					}
					queue1.pop();
					queue2.pop();
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb.toString());
		
	}

}

class ArQueue {
	
	int max;
	int front;
	int back;
	int[] queueArr;
	
	public ArQueue(int max) {
		this.max=max;
		front=back=0;
		queueArr=new int[max];
	}
	
	public int size() {
		return back-front;
	}
	
	public boolean isEmpty() {
		if(front==back) {
			return true;
		} 
		return false;
	}
	
	public boolean isFull() {
		if(back==max) {
			return true;
		}
		return false;
	}
	
	public void push(int value) {
		if(isFull()) {
			return;
		}
		queueArr[back++] = value;
	}
	
	public int pop() {
		if(isEmpty()) {
			return -1;
		}
		return queueArr[front++];
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		return queueArr[front];
	}
}
