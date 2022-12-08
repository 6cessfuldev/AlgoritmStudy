package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1010 {
	
	static int[][] dp ;
	
	static int BC(int n, int k) {
		
		if(dp[n][k]>0) {
			return dp[n][k];
		}
		if(n==k || k==0) return 1;
		
		return dp[n][k] = (BC(n-1,k)+BC(n-1,k-1));
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		dp = new int[31][31];
		
		for (int i = 0; i < T; i++) {
			String[] strArr = br.readLine().split(" ");
			int k = Integer.parseInt(strArr[0]);
			int n = Integer.parseInt(strArr[1]);
			
			int rs = BC(n,k);
			sb.append(rs+"\n");
		}
		System.out.println(sb);

	}

}
