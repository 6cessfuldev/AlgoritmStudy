package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1074 {

	public static int find(int n, int x, int y) {

		int N = (int)Math.pow(2, n);
		if(n ==1) {
			if(x==0 && y==0) return 0;
			if(x==0 && y==1) return 1;
			if(x==1 && y==0) return 2;
			if(x==1 && y==1) return 3;
		}
		
		if(x<N/2 && y<N/2) return find(n-1,x,y);
		if(x<N/2 && y>=N/2) return find(n-1, x,y-N/2)+(int)Math.pow(4, n-1);
		if(x>=N/2 && y<N/2) return find(n-1, x-N/2,y)+2*(int)Math.pow(4, n-1);
		if(x>=N/2 && y>=N/2) return find(n-1, x-N/2, y-N/2)+3*(int)Math.pow(4, n-1);
		
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int r = Integer.parseInt(strArr[1]);
		int c = Integer.parseInt(strArr[2]);		
		
		System.out.println(find(N,r,c));

	}
	
	

}
