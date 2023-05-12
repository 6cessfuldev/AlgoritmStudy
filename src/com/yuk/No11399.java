package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		while(stk.hasMoreTokens()) {
			que.add(Integer.parseInt(stk.nextToken()));
		}
		
		int[] arr = new int[N];
	
		for (int i = 0; i < arr.length; i++) {
			arr[i] = que.poll();
		}
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				sum += arr[j];
			}
		}
		
		System.out.println(sum);
	}

}
