package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[100][100];
		while(n-- > 0) {
			
			String[] strArr = br.readLine().split(" ");
			int x = Integer.parseInt(strArr[0]);
			int y = Integer.parseInt(strArr[1]);
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					arr[i][j] = true;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j]) sum++;	
			}
		}
		
		System.out.println(sum);
		
		

	}

}
