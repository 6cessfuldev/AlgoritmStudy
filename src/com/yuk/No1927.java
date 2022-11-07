package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		MinHeap heap = new MinHeap(N);
		while(N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if(x>0) {
				heap.insert(x);
			} else {
				heap.out();
			}
		}
	}
}

class MinHeap{
	int max;
	int[] arr;
	int front = 1;
	int back = 1;
	
	public MinHeap(int N) {
		this.max = N;
		arr = new int[N+1]; 
	}
	
	public void insert(int x) {
		int tmp = back;
		back++;
		while(tmp>1) {
			if(tmp/2<front) break;
			if(x<arr[tmp/2]) {
				arr[tmp]=arr[tmp/2];
				tmp=tmp/2;
			}else {
				break;
			}
		}
		arr[tmp] = x;
	}
	
	public void out() {
		int tmp = arr[back];
		while(tmp>back) {
			
		}		
	}
}
