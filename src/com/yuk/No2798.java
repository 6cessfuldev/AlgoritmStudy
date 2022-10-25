package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2798 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		
		String[] arr1 = br.readLine().split(" ");
		int[] intArr = new int[N];
		for (int i = 0; i < N; i++) {
			intArr[i] = Integer.parseInt(arr1[i]);
		}

		int max = 0;
		for (int i = 0; i < intArr.length-2; i++) {
			for (int j = i+1; j < intArr.length-1; j++) {
				for (int j2 = j+1; j2 < intArr.length; j2++) {
					
					int sum = intArr[i]+intArr[j]+intArr[j2];
					
					if(sum<=M) {
						if(sum>max) {
							max=sum;
						}
					}
					
				}
			}
		}
		
		System.out.println(max);
		
	}

}
