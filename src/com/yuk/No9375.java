package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No9375 {
	
	private static int sum;
	private static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
						
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i <n; i++) {
				String[] strArr = br.readLine().split(" ");
				map.put(strArr[1], map.getOrDefault(strArr[1], 0)+1);				
			}
			
			int rs = 1;
			
			for (int i : map.values()) {
				rs *= i+1;
			}
			sb.append(rs-1).append("\n");
			
		}
		System.out.println(sb);
	}

}
