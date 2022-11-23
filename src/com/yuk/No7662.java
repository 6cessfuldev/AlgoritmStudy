package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class No7662 {
	
	public static int remove(Queue<Integer> queue, Map<Integer, Integer> map) {
		
		int num;
		while(true) {
			num = queue.poll();
			int cnt = map.getOrDefault(num,0);
			if(cnt == 0) continue;
			else if(cnt == 1) map.remove(num);
			else {
				map.put(num, cnt-1);			
			}
			break;
		}
		
		return num;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			Map<Integer, Integer> map = new HashMap<>();
			PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minQ = new PriorityQueue<>();
			
			while(k-- >0) {				
				
				String[] strArr = br.readLine().split(" ");
				
				if(strArr[0].equals("I")) {
					int in = Integer.parseInt(strArr[1]);
					map.put(in, map.getOrDefault(in, 0) + 1);
					maxQ.add(in);
					minQ.add(in);
				}else {
					if(map.size()!=0) {
						if(strArr[1].equals("1")) {
							remove(maxQ, map);
						} else {
							remove(minQ, map);
						}
					}
				}
				
//				System.out.print("map ");
//				for (int a : map.keySet()) {
//					System.out.print(" "+a);
//				}
//				System.out.println();
//				System.out.print("max ");
//				for (int a : maxQ) {
//					System.out.print(" "+a);
//				}
//				System.out.println();
//				System.out.print("min ");
//				for (int a : minQ) {
//					System.out.print(" "+a);
//				}
			}
			
			if(map.isEmpty()) {
				sb.append("EMPTY");
			} else if(map.size()==1) {
				int max = remove(maxQ, map);
				sb.append(max).append(" ").append(max);
			}else {
				int max = remove(maxQ, map);
				int min = remove(minQ, map);
				sb.append(max).append(" ").append(min);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
