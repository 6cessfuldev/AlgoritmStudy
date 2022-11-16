package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No7576 {

	static int[][] arr;
	static boolean[][] visit;
	static int[] x = {0, 1, 0, -1};
	static int[] y = {-1, 0, 1, 0};
	static int m;
	static int n;
	static int day;
	
	static void dfs() {
		
		boolean flag = false;
		
		while(true) {
		
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j]==1) {
						System.out.println("a["+i+"]["+j+"]");
						
						for (int k = 0; k < 4; k++) {
							int nextX = i+x[k];
							int nextY = j+y[k];
							
							if(nextX>=0 && nextX<n && nextY>=0 && nextY<m) {
								if(arr[nextX][nextY]==0) {
									arr[nextX][nextY] = 1;
									flag = true;
								}
							}
						}			
					}
				}
			}
			
			if(!flag) break;
			day++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		m = Integer.parseInt(strArr[0]);
		n = Integer.parseInt(strArr[1]);
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			
			String[] strArr1 = br.readLine().split(" ");
			
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(strArr1[j]);
			}

		}
		
		dfs();
		
		System.out.println(day);
		
	}

}
