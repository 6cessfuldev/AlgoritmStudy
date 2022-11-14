package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2606 {
	
	static boolean[] visit;
	static int[][] map;
	static int n;
	static int cnt=0;
	
	public static void dfs(int num) {
		
		visit[num] = true;
		cnt++;
		for (int i = 0; i < map.length; i++) {
			if(i!=num && map[num][i]==1 && !visit[i]) {
				dfs(i);
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < m; i++) {
			String[] strArr = br.readLine().split(" ");
			int a = Integer.parseInt(strArr[0]);
			int b = Integer.parseInt(strArr[1]);
			map[a-1][b-1]=1;
			map[b-1][a-1]=1;
		}
		
		dfs(0);
		System.out.println(cnt-1);
	}

}
