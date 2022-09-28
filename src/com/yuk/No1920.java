package com.yuk;

import java.util.Arrays;
import java.util.Scanner;

public class No1920 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//첫번째 배열
		int N = scan.nextInt();
		int[] arr1 = new int[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = scan.nextInt();
		}

		//두번째 배열
		int M = scan.nextInt();
		int[] arr2 = new int[M];
		for (int i = 0; i < M; i++) {
			arr2[i] = scan.nextInt();
		}
		
		Arrays.sort(arr1);
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(binarySearch(arr1, arr2[i])+" ");
		}
	}
	
	public static int binarySearch (int[] arr, int key) {
		
		int lo = 0;
		int hi = arr.length-1;
		
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if(arr[mid] > key) {
				hi = mid-1;
			} else if(arr[mid] < key){
				lo=mid+1;
			} else {
				return 1;
			}
		}
		
		return 0;
	}
}
