package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11050 {

	public static int factorial(int n) {
		
		if(n == 1) return 1;
		if(n == 0) return 1;
		
		return n*factorial(n-1);
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		int n = Integer.parseInt(strArr[0]);
		int k = Integer.parseInt(strArr[1]);
				
		System.out.println(factorial(n)/factorial(n-k)/factorial(k));

	}

}
