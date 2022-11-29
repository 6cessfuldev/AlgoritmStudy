package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class No5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		loop1  :
		while(T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> deq = new ArrayDeque<>();
			StringTokenizer stk = new StringTokenizer(br.readLine(),"[],");
			for (int i = 0; i < n; i++) {
				deq.addLast(Integer.parseInt(stk.nextToken()));
			}			
//			ArrayList<String> order = strArr(p);
//			
//			for (int i = 0; i < order.size(); i++) {
//				if(order.get(i).charAt(0)=='R') {
//					rCnt++;
//				} else {
//					int dCnt = Integer.parseInt(order.get(i).substring(1));
//					if(dCnt>deq.size()) {
//						sb.append("error\n");
//						continue loop1;
//					}
//					if(rCnt%2 == 0) {
//						for (int j = 0; j < dCnt; j++) {
//							deq.removeFirst();
//						}						
//					}else {
//						for (int j = 0; j < dCnt; j++) {
//							deq.removeLast();
//						}	
//					}
//				}
//			}
//			if(rCnt%2==1) {
//				ArrayList<Integer> list = new ArrayList<>();
//				while(!deq.isEmpty()) {
//					list.add(deq.removeLast());
//				}
//				sb.append(list).append("\n");
//			}else {
//				sb.append(deq.toString()).append("\n");				
//			}
			int rCnt = 0;
			for (int i = 0; i < p.length(); i++) {
				
				if(p.charAt(i)=='R') {
					rCnt++;
				} else {
					if(deq.isEmpty()) {
						sb.append("error\n");
						continue loop1;
					}
					if(rCnt%2==0) {
						deq.removeFirst();
					}else {
						deq.removeLast();
					}
				}
			}
			if(rCnt%2==1) {
				ArrayList<Integer> list = new ArrayList<>();
				while(!deq.isEmpty()) {
					list.add(deq.removeLast());
				}
				sb.append(list).append("\n");
			}else {
				sb.append(deq.toString()).append("\n");				
			}			

		}

		String rs = sb.toString().replaceAll("[ ]", "");
		
		System.out.println(rs);
	}
	
	public static ArrayList<String> strArr(String p) {
		ArrayList<String> list = new ArrayList<>();
		
		if(p.length()==1) {
			list.add(p+1);
			return list;
		}
		
		int cnt = 1;
		for (int i = 1; i < p.length(); i++) {
			if(p.charAt(i) != p.charAt(i-1)) {
				list.add(String.valueOf( p.charAt(i-1))+cnt);
				cnt=1;
			}else {
				cnt++;
			}
			
			if(i==p.length()-1) {
				list.add(String.valueOf(p.charAt(i))+cnt);
			}
		}
		return list;
	}

}
