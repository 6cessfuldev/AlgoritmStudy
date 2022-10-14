package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No25305 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int k = Integer.parseInt(strArr[1]);
		String[] scoArr = br.readLine().split(" ");
		int[] arr = new int[N];
				
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(scoArr[i]);
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[N-k]);
	}

}
