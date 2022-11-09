package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2178 {

	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visit;
	static int[][] min;
	static int[] arrX = {-1, 0, 1, 0};
	static int[] arrY = {0, -1, 0, 1};
	
	public static int go(int x, int y) {
		
		if(x==0 && y==0) {
			min[x][y]=1;
			return 1;
		}
		
		if(!visit[x][y]) {
			
			int mini = Integer.MAX_VALUE;
			for(int i=0; i<4; i++) {
				int tmpX = x+arrX[i];
				int tmpY = y+arrY[i];
				if(tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<M) {
					if(mini > go(tmpX,tmpY)){
						mini = go(tmpX,tmpY);
					}
				}
			}	
			min[x][y]=mini+1;
			visit[x][y]=true;
		}
		
		return min[x][y];
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		N = Integer.parseInt(strArr[0]);
		M = Integer.parseInt(strArr[1]);
		
		map = new char[N][M];
		visit = new boolean[N][M];
		min = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		go(N-1,M-1);
		System.out.println(min[N-1][M-1]);
		
	}
}
