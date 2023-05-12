package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2630 {

	static int n;
	static int[][] arr;
	static int one;
	static int zero;
	
	
	static void dq(int x, int y, int num) {
		
		boolean flag = true;
		int first = arr[x][y];
		loop :
		for (int i = x; i < x+num; i++) {
			for (int j = y; j < y+num; j++) {
				if(arr[i][j]!=first) {
					flag = false;
					break loop;
				}
			}
		}
		
		if(flag) {
			if(first == 1) one++;
			else zero++;
		} else {
			num=num/2;
			dq(x, y, num);
			dq(x+num, y, num);
			dq(x, y+num, num);
			dq(x+num, y+num, num);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] strArr = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(strArr[j]);
			}
		}
		
		dq(0,0,n);
		
		System.out.println(zero);
		System.out.println(one);
	}

}