package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2630 {
	
	static int n;
	static int[][] arr;
	static int one;
	static int zero;

	public static void dq(int x, int y, int num) {
		
		boolean flag = true;
		int first = arr[x][y];
		loop: 
		for (int i = x; i < x+num; i++) {
			for (int j = y; j < y+num; j++) {
				if(arr[i][j]!=first) {
					flag=false;
					break loop;
				}
			}
		}
		
		if(flag) {
			if(first==1) one++;
			else zero++;
		} else {
			dq(x,y,num/2);
			dq(x+num/2,y+num/2,num/2);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] strArr = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j]=Integer.parseInt(strArr[j]);
			}
		}
		
		
	}

}
