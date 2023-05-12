package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No15649 {
	static StringBuilder sb = new StringBuilder();
	
	public static void backTracking(ArrayList<Integer> arr, int N, int M) {
		
		if(arr.size() == 0) {
			for (int i = 1; i <= N; i++) {
				arr=new ArrayList<>();
				arr.add(i);
				backTracking(arr, N, M);
			}
			return;
		}
		
		if(arr.size() == M) {
			for (int i = 0; i < arr.size(); i++) {
				sb.append(arr.get(i)+" ");
			}
			sb.append("\n");
			return;
		}
		
		if(arr.size() < M) {
			
			for (int i = 1; i <= N; i++) {
				if(arr.contains(i)) {
					continue;
				}else {
					arr.add(i);
					backTracking(arr, N, M);
					arr.remove(arr.size()-1);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		
		backTracking(new ArrayList<Integer>(), N, M);
		System.out.println(sb);
	}

}
