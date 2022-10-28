package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			 int N = Integer.parseInt(br.readLine());
			sb.append(zeroSum(N)+" "+oneSum(N)+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int zeroSum(int n) {
		
		if(n==0) return 1;
		if(n==1) return 0;
		return zeroSum(n-1)+zeroSum(n-2);
		
	}
	
	public static int oneSum(int n) {
		
		if(n==0) return 0;
		if(n==1) return 1;
		return oneSum(n-1)+oneSum(n-2);
		
	}
}