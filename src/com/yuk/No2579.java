package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2579 {
	
	static int[] arr;
	static int[] sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		sum = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		System.out.println(dp(n));
		
	}

	public static int dp(int n) {
		
		if(n == 1) {
			sum[1]=arr[1];
			return sum[1];
		}
		if(n == 2) {
			sum[2] = arr[1]+arr[2];
			return sum[2];
		}
		
		if(sum[n] == 0) {
			//연속 세 개의 계단을 밝아서는 안된다
			if(dp(n-1)-dp(n-2)==arr[n-1]) {
				sum[n]=dp(n-2)+arr[n];
			}
			
			//첫번째 전 계단, 혹은 두번쨰 전 계단에서 올라와야 한다.
			else {
				sum[n]=Math.max(dp(n-1), dp(n-2))+arr[n];				
			}
		}
		
		return sum[n];
	}
}
