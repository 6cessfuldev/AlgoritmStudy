package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11726 {
	
	static int[] arr ;
	
	public static int cnt(int n) {
		
		if(arr[n] == 0) {
			
			if(n == 1) {
				arr[n] = 1;
			}else if(n == 2) {
				arr[n] = 2;
			}else {
				arr[n] = (cnt(n-1)+cnt(n-2))%10007;
			}
		}
		
		return arr[n];
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[1001];
		
		System.out.println(cnt(n)%10007);

	}

}
