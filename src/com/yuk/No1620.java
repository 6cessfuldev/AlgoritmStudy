package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		HashMap<Integer, String> numlist = new HashMap<>();
		HashMap<String, Integer> namelist = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			String input = br.readLine();
			numlist.put(i, input);
			namelist.put(input, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String qs = br.readLine();
			if(qs.matches("[+-]?\\d*(\\.\\d+)?")) {
				int num = Integer.parseInt(qs);
				sb.append(numlist.get(num)).append("\n");
			} else {
				sb.append(namelist.get(qs)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
