package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class No2587 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum/5);
		Arrays.sort(arr);
		System.out.println(arr[2]);
		
	}
}
