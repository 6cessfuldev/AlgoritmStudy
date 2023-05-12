package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No9461 {

	static long[] dp= new long[101];
	
	static long P(int n) {
		
		if(dp[n]==0) {
		
			dp[n] = P(n-5)+P(n-1);
			
		}

		return dp[n];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		
		while(T-- > 0) {
						
			int n = Integer.parseInt(br.readLine());
		
			sb.append(P(n)).append("\n");
			
		}
		
		System.out.println(sb);
			
	}

}
