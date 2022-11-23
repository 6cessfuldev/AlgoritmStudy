package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095 {

	static int[] arr;
	
	public static int sum(int n) {
		
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
		
		if(n==4) {
			// 1 1 1 1
			// 2 1 1
			// 1 2 1
			// 1 1 2
			// 3 1
			// 1 3
		}
		
		return arr[n];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
		}
		
		
		
	}

}
