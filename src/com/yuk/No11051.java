package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11051 {
	
	static int[][] dp ;
	
	static int BC(int n, int k) {
		
		if(dp[n][k]>0) {
			return dp[n][k];
		}
		if(n==k || k==0) return 1;
		
		return dp[n][k] = (BC(n-1,k)+BC(n-1,k-1))%10007;
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		int n = Integer.parseInt(strArr[0]);
		int k = Integer.parseInt(strArr[1]);
		
		dp = new int[n+1][k+1];
		
		
		int rs = BC(n,k);
		System.out.println(rs);

	}

}
