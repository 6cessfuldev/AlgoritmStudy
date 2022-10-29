package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1003 {
	
	static int[] zeroarr = new int[41];
	static int[] onearr = new int[41];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		init();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			 int N = Integer.parseInt(br.readLine());
			sb.append(zeroSum(N)+" "+oneSum(N)+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void init() {
		for (int i = 0; i < onearr.length; i++) {
			zeroarr[i]=onearr[i]=-1;
		}
	}
	
	public static int zeroSum(int n) {
		
		if(zeroarr[n] != -1) {
			return zeroarr[n];
		}
		
		if(n==0) {
			zeroarr[0]=1;
			return 1;
		}
		if(n==1) {
			zeroarr[1]=0;
			return 0;
		}
		
		zeroarr[n] = zeroSum(n-1)+zeroSum(n-2);
		return zeroSum(n-1)+zeroSum(n-2);
		
	}
	
	public static int oneSum(int n) {
		
		if(onearr[n] != -1) {
			return onearr[n];
		}
		
		if(n==0) {
			onearr[0]=0;
			return 0;
		}
		if(n==1) {
			onearr[1]=1;
			return 1;
		}
		
		onearr[n] = oneSum(n-1)+oneSum(n-2);
		return oneSum(n-1)+oneSum(n-2);
		
	}
}