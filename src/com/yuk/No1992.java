package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1992 {

	static int N;
	static char[][] arr;
	static String result="";
	
	public static void zip(int x, int y, int n) {
		
		char first = arr[x][y];
		boolean flag = true;
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if(first != arr[i][j]) {
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			result+=first;
		}else{
			result+='(';
			zip(x,y,n/2);
			zip(x,y+n/2,n/2);
			zip(x+n/2,y,n/2);
			zip(x+n/2,y+n/2,n/2);
			result+=')';
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		int n = N;
		while(N-- > 0) {
			String str = br.readLine();
			for (int i = 0; i < arr.length; i++) {
				arr[arr.length-N-1][i] = str.charAt(i);
			}
		}
		
		zip(0,0,n);
		System.out.println(result);
	}

}
