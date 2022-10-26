package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15829 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int M = 1234567891;
		
		long sum = 0;
		long pow = 1;
		
		for (int i = 0; i < l; i++) {
			sum += (str.charAt(i)-'a'+1)*pow%M;
			pow = pow*31%M;
		}
		System.out.println(sum%M);
	}

}
