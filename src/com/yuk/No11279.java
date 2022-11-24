package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class No11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
		while(N-- >0) {
			
			int x = Integer.parseInt(br.readLine());
			if(x>0){
				que.add(x);
			} else {
				if(que.isEmpty()) {
					sb.append("0");
				}else {
					sb.append(que.poll());
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);

	}

}
