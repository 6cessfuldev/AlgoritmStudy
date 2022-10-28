package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No18111 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		int B = Integer.parseInt(strArr[2]);
		
		int[] arr = new int[N*M];
		int cnt= 0;
		int max = 0;
		int min = 256;
		while(N-- > 0) {
			String[] strAr = br.readLine().split(" ");
			for (int i = 0; i < strAr.length; i++) {
				arr[cnt] = Integer.parseInt(strAr[i]);
				if(arr[cnt]> max){
					max = arr[cnt];
				}
				if(arr[cnt] < min) {
					min = arr[cnt];
				}
				cnt++;
			}
		}

		int rs = Integer.MAX_VALUE;
		int floor = -1;
		// 시간 계산 및 사용할 수 있는 블럭 수 고려하여 경우의 수 제외
		for (int i = min; i <= max; i++) {
			int sum = 0;
			int block = B;
			for (int j = 0; j < arr.length; j++) {
				int need = Math.abs(i-arr[j]);
				if(arr[j]>i) {
					sum += 2*(need);
					block+=need;
				}
				if(arr[j]<i) {
					sum += need;
					block-=need;
				}
			}
			
			if(block<0) continue;
			
			if(sum<=rs) {
				rs=sum;
				floor=i;
			}	
		}
		System.out.println(rs+" "+floor);
	}
}
