package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095 {

	static int[] arr = new int[11];
	
	public static int dp(int n) {
		
		if(n==1) {
			arr[1] = 1;
			return 1;
		}
		
		if(n==2) {
			arr[2] = 2;
			return 2;
		}
		
		if(n==3) {
			arr[3] = 4;
		}

		if(arr[n]==0) {
			arr[n] = dp(n-1)+dp(n-2)+dp(n-3);
		}
		
		return arr[n];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp(n)).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
