package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;

public class No15651 {

	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int N, int M, int depth) {
	
		if(depth == M) {
		
			for (int i : arr) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
		
			arr[depth] = i+1;
			dfs(N, M, depth+1);
		
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		visit = new boolean[N];
		arr = new int[M];
		
		dfs(N, M, 0);
		
		System.out.println(sb);
	}

}
