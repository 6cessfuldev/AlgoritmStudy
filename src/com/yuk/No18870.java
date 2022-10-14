package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class No18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =Integer.parseInt(br.readLine());
		
		String[] strArr = br.readLine().split(" ");
		
		int[] arr = new int[N];
		 
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		
		int[] sorting = new int[N];
		
		for (int i = 0; i < sorting.length; i++) {
			sorting[i] = arr[i];
		}
		
		Arrays.sort(sorting);
		int rank = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(sorting[0], rank);
		for (int i = 1; i < sorting.length; i++) {
			if(sorting[i]!=sorting[i-1]) {
				map.put(sorting[i], ++rank);
			}else {
				map.put(sorting[i], rank);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = map.get(arr[i]);
			sb.append(arr[i]+" ");
		}	
		
		System.out.println(sb.toString());
		
	}

}
