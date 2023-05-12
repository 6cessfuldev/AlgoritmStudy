package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class No1934 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			String[] strArr =br.readLine().split(" ");
			int x = Integer.parseInt(strArr[0]);
			int y = Integer.parseInt(strArr[1]);
			sb.append(x*y/gcd(x,y)+"\n");
		}
		System.out.println(sb);
		
	}
	
	 public static int gcd(int p, int q)
	 {
		if (q == 0) return p;
		return gcd(q, p%q);
	 }
}
