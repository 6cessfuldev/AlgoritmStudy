package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10815 { 

	public static boolean binaryFind (int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while (lo<hi) {
			int mid = (lo+hi)/2;
			System.out.println();
			System.out.println("lo "+ lo);
			System.out.println("mid "+mid);
			System.out.println("hi "+ hi);
			if(mid == key) return true;
			else if(key < arr[mid]) {
				hi = mid;
			} else {
				lo = mid+1;
			} 
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(stk.nextToken());
			System.out.println("target : "+target);
			if(binaryFind(arr, target)) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
		

	}

}
