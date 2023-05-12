package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class No2981 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] arr= new int[N];
		for(int i=0; i<N; i++){
			int x = Integer.parseInt(br.readLine());
			arr[i] = x;
		}
		Arrays.sort(arr);
		int gcdVal = arr[1]-arr[0];
		for (int i = 2; i < arr.length; i++) {
			gcdVal = gcd(gcdVal,arr[i]-arr[i-1]);
		}
		
		for (int i = 2; i <= gcdVal; i++) {
			if(gcdVal%i==0) sb.append(i+" ");
		}
		System.out.println(sb);
	}
	
	 public static int gcd(int p, int q)
	 {
		if (q == 0) return p;
		return gcd(q, p%q);
	 }
}
