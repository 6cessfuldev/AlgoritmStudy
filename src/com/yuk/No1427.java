package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1427 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[(int)Math.log10(N)+1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = N%10;
			N = N/10;
		}
		
		Arrays.sort(arr);
		

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[arr.length-1-i]);  
		}
		
		
	}

}
