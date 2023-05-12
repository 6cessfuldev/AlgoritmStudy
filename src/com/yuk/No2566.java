package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2566 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			
			String[] matrix = br.readLine().split(" "); 
			
			for (int j = 0; j < 9; j++) {
				
				arr[i][j] = Integer.parseInt(matrix[j]); 
				
			}
		}
		
		int max = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < 9; i++) { 
			for (int j = 0; j < 9; j++) {
				if(max<arr[i][j]) {
					
					max = Math.max(max, arr[i][j]);
					x = i;
					y = j;
				}
				
			}
		}
		
		System.out.println(max);
		System.out.println((x+1)+ " "+ (y+1));

	}

}
