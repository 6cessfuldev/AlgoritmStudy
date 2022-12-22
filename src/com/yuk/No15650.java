package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;

public class No15650 {

	static boolean[] visit;
	static int[] arr;
	
	public static void dfs(int N, int M, int depth, int prev) {
	
		if(depth == M) {
		
			for (int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
		
			if(visit[i] == false && prev <= i ) {
				
				visit[i] = true;
				arr[depth] = i+1;
				prev = arr[depth];
				dfs(N, M, depth+1, prev);
				
				visit[i] = false;
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		visit = new boolean[N];
		arr = new int[M];
		
		dfs(N, M, 0, 0);
	}

}
