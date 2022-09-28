package com.yuk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class No10816 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//첫번째 배열
		int N = scan.nextInt();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int key = scan.nextInt();
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			} else {
				map.put(key, 1);
			}
		}
		
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		
		int[] arr = new int[map.size()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = it.next(); 
		}
		
		Arrays.sort(arr);
		
		int M = scan.nextInt();
		int[] arr2 = new int[M];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = scan.nextInt();
		}
		
		for (int i = 0; i < M; i++) {
			if(binarySearch(arr,arr2[i]) == 1) {
				System.out.print(map.get(arr2[i])+" ");
			} else {
				System.out.print("0 ");
			}
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
				if(arr[mid] == arr[mid+1]) {
					
				}
				return 1;
			}
		}
		
		return 0;
	}
	
	public static int lowerBound (int[] arr, int key) {
		int lo = 0;
		int hi = arr.length-1;
		
		while (lo<=hi) {
			int mid = (lo+hi)/2;
			
			if(key < arr[mid]) {
				hi = mid;
			} else {
				
			}
			
		}
	}
}
