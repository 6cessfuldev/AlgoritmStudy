package com.yuk;

import java.util.Scanner;

public class No2805 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		long max = 0;
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
			if(max < arr[i]) max = arr[i];
		}

		max++;
		
		long min = 0;
		long mid = 0;
		
		while (min < max) {
		
			mid = (min + max)/2;
			long sum = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]-mid>0) {
					sum += arr[i]-mid;
				}
			}
			if(sum >= M){
				min = mid+1;
			} else {
				max = mid;
			}
		}
		
		System.out.println(min-1);
		
		
		
	}

}
