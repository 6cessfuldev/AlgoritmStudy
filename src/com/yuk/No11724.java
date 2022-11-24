package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11724 {

	static int N;
	static int M;
	static int[][] map;
	static boolean[] visit;
	
	public static boolean dfs(int x) {
		
		visit[x] = true;
		for (int i = 1; i <= N; i++) {
		    if(map[x][i] == 1 && !visit[i]) {
		    	dfs(x);
		    }
		}
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			String[] strArr = br.readLine().split(" ");
			int a = Integer.parseInt(strArr[0]);
			int b = Integer.parseInt(strArr[1]);
			map[a][b] = 1;
			map[b][a] = 1;	
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {
				if(dfs(i)) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
