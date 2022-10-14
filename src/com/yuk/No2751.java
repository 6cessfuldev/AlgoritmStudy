package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2751 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < arr.length; i++) {
			counting[arr[i]]++;
		}
		
		for (int i = 0; i < counting.length-1; i++) {
			counting[i+1] += counting[i];
		}
		
		for (int i = arr.length-1; i >= 0; i--) {
			int value = arr[i];
			result[--counting[value]]= value;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			if(result[i] != 0) sb.append(result[i]+"\n");
		}
		
		System.out.println(sb.toString());
	}
}

 
