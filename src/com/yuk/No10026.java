package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class No10026 {

	static char[][] map;
	static boolean[][] visit;
	static int n;
	static int[] arrx = {0, 1, 0, -1};
	static int[] arry = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map =new char[n][n];
		visit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i] = str.toCharArray();
			}
		}
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if(!visit[i][j]) {
					dfs(i,j);
					cnt++;
				}
				
			}
		}
		
		int cntRG = 0;
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if(!visit[i][j]) {
					dfs2(i,j);
					cntRG++;
				}
				
			}
		}
		
		System.out.print(cnt+" ");
		System.out.println(cntRG);

	}
	
	public static void dfs(int x, int y) {
		
		visit[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			
			int nextx = x + arrx[i];
			int nexty = y + arry[i];
			
			if(nextx>=0 && nextx<n && nexty>=0 && nexty<n && !visit[nextx][nexty]) {
				
				if(map[nextx][nexty] == map[x][y]) {
					dfs(nextx, nexty);				
				}
			}
		}
	}
	
	public static void dfs2(int x, int y) {
		
		visit[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			
			int nextx = x + arrx[i];
			int nexty = y + arry[i];
			
			if(nextx>=0 && nextx<n && nexty>=0 && nexty<n && !visit[nextx][nexty]) {
				
				if(map[nextx][nexty] == map[x][y]) {
					dfs2(nextx, nexty);
					continue;
				}
				if(map[x][y]=='R' && map[nextx][nexty]=='G') {
					dfs2(nextx, nexty);
					continue;
				}
				if(map[x][y]=='G' && map[nextx][nexty]=='R') {
					dfs2(nextx, nexty);
					continue;
				}
			}
		}
	}

}
