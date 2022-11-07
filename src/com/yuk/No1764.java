package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1764 {

	static int N;
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		Collections.sort(list);
		
		int cnt = 0;
		ArrayList<String> result = new ArrayList<>();
		while(M-->0) {
			String name = br.readLine();
			if(find(name)) {
				cnt++;
				result.add(name);
			}
		}
		Collections.sort(result);
		for (String string : result) {
			sb.append(string).append("\n");
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
	
	public static boolean find(String name) {
		int top = N-1;
		int btm = 0;
		
		while(btm<=top) {
			int mid = (top+btm)/2;
			if(name.equals(list.get(mid))){
				return true;
			}
			if(list.get(mid).compareTo(name)<0){
				btm = mid+1;
			}else {
				top = mid-1;
			}
		}
		return false;
	}
}
