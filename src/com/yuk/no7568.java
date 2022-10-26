package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		int i = 0;
		while(n-- > 0) {
			String[] strArr = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strArr[0]);
			arr[i++][1] = Integer.parseInt(strArr[1]); 
		}
		
		for (int j = 0; j < arr.length; j++) {
			int rank = 1;
			for(int j2 = 0; j2 < arr.length; j2++) {
				if(arr[j][0]< arr[j2][0] && arr[j][1]<arr[j2][1]) {
					rank++;
				}
			}
			sb.append(rank).append(' ');
				
		}
		
		
		System.out.print(sb.toString());
	}

}
