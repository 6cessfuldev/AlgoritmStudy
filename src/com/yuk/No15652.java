package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;

public class No15652 {

	static int[] arr;
	
	public static void dfs(int N, int M, int depth, int prev) {
	
		if(depth == M) {
		
			for (int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
		
			if(prev <= i ) {
				
				arr[depth] = i;
				prev = arr[depth];
				dfs(N, M, depth+1, prev);
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		arr = new int[M];
		
		dfs(N, M, 0, 0);
	}

}
