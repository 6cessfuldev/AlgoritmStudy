package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2420 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		long N = Long.parseLong(strArr[0]);
		long M = Long.parseLong(strArr[1]);
		
		System.out.println(Math.abs(N-M));
		
	}
}