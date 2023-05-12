package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11727 {
	
	static int[] arr ;
	
	public static int cnt(int n) {
		
		if(arr[n] == 0) {
			
			if(n == 1) {
				arr[n] = 1;
			}else if(n == 2) {
				arr[n] = 3;
			}else if(n == 3){
				arr[n] = 5;
			}else if(n == 4){
				arr[n] = 2*cnt(n-2)+cnt(n-1);
			}else {
				arr[n] = (2*cnt(n-2)%10007+cnt(n-1)%10007)%10007;
			}
		}
		
		return arr[n];
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[1001];
		
		System.out.println(cnt(n));

	}

}
