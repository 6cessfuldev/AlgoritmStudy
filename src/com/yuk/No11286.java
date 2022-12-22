package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class No11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> quePlus = new PriorityQueue<Integer>();
		PriorityQueue<Integer> queMinus = new PriorityQueue<Integer>(Collections.reverseOrder());
		while(N-- >0) {
			
			int x = Integer.parseInt(br.readLine());
			if(x!=0){
				if(x>0) quePlus.add(x);
				else queMinus.add(x);
			} else {
				if(quePlus.isEmpty() && queMinus.isEmpty()) {
					sb.append("0");
				}else if(quePlus.isEmpty()){
					sb.append(queMinus.poll());
				}else if(queMinus.isEmpty()){
					sb.append(quePlus.poll());
				}else { //틍과
					if( Math.abs(quePlus.peek()) < Math.abs(queMinus.peek()) ) {
						sb.append(quePlus.poll());
					}else {
						sb.append(queMinus.poll());
					}
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);

	}

}
