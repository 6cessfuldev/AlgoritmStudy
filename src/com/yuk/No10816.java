package com.yuk;

import java.util.Arrays;
import java.util.Scanner;

public class No10816 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//첫번째 배열
		int N = scan.nextInt();
				
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		int M = scan.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			int key = scan.nextInt();
			sb.append(upperBound(arr, key)-lowerBound(arr, key)).append(' ');
		}
		System.out.println(sb);
			
	}
	
	public static int lowerBound (int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while (lo<hi) {
			int mid = (lo+hi)/2;
			
			if(key <= arr[mid]) {
				hi = mid;
			} else {
				lo = mid+1;
			} 
			
		}
		return lo;
	}
	
	public static int upperBound (int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while (lo<hi) {
			int mid = (lo+hi)/2;
			
			if(key < arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			} 
			
		}
		return lo;
	}
}
