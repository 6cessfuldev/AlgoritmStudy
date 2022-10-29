package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1012 {
	
	static int M, N, K;
	static int[][] arr;
	static boolean[][] visit;
	static int cnt;
	static int[] xarr = {0, 1, 0, -1};
	static int[] yarr = {1, 0, -1, 0};
	
	static void dfs(int x, int y) {
		visit[x][y] =  true;
		
		for (int i = 0; i < xarr.length; i++) {
			int cx =x+xarr[i];
			int cy =y+yarr[i];
			
			if(cx>=0 && cy>=0 && cx<M && cy<N) {
				if(arr[cx][cy]==1 && !visit[cx][cy]) {
					dfs(cx,cy);					
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String[] strArr = br.readLine().split(" ");
			M = Integer.parseInt(strArr[0]);
			N = Integer.parseInt(strArr[1]);
			K = Integer.parseInt(strArr[2]);
			
			arr = new int[M][N];
			visit = new boolean[M][N];
			cnt=0;
			while(K-- > 0) {
				String[] strArr1 = br.readLine().split(" ");
				int x = Integer.parseInt(strArr1[0]);
				int y = Integer.parseInt(strArr1[1]);
				arr[x][y] = 1;
 			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]==1 && !visit[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append(" ");			
		}
		
		System.out.println(sb.toString());
	}
	
	
}
