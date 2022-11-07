package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1780 {

	static int N;
	static int[][] arr;
	static int minus;
	static int zero;
	static int plus;
	
	public static void count(int x, int y, int k) {
		int minusCnt=0;
		int zeroCnt=0;
		int plusCnt=0;
		int total = (int)(Math.pow(3, k)*Math.pow(3, k));
		
		for (int i = x; i < x+Math.pow(3, k); i++) {
			for (int j = y; j < y+Math.pow(3, k); j++) {
				switch (arr[i][j]) {
				case -1 :
					minusCnt++;
					break;
				case 0 :
					zeroCnt++;
					break;
				case 1 :
					plusCnt++;
					break;
				}
			}
		}
		if(minusCnt == total||zeroCnt == total||plusCnt == total) {
			if(minusCnt == total) minus++;
			if(zeroCnt == total) zero++;
			if(plusCnt == total) plus++;
		} else {
			for (int i = x; i < x+Math.pow(3, k); i+=Math.pow(3, k-1)) {
				for (int j = y; j < y+Math.pow(3, k); j+=Math.pow(3, k-1)) {
					count(i,j,k-1);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int n = N;
 		while(N-- > 0) {
 			
			String[] strArr = br.readLine().split(" ");
			for (int i = 0; i < strArr.length; i++) {
				arr[n-N-1][i] = Integer.parseInt(strArr[i]);
			}
		}
 		
 		count(0, 0, (int)(Math.log10(n)/Math.log10(3)));
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
}
