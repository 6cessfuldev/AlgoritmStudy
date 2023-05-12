package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No11403 {

	static int[][] map;
	static int N;
	static int[][] rs;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		rs = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			
			String[] strArr = br.readLine().split(" ");
			
			for (int j = 0; j < strArr.length; j++) {
			
				map[i][j] = Integer.parseInt(strArr[j]);
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print( bfs(i, j)+" " );
			}
			System.out.println();
		}
		
	}
	
	public static int bfs(int x, int y) {
		
		visit = new boolean[N];
		
		Queue<Integer> que = new LinkedList<>();
		que.add(x);
		
		while(!que.isEmpty()) {
			
			int tmp = que.poll();
			
			for (int i = 0; i < N; i++) {
				
				if(!visit[i] && map[tmp][i]==1) {
					if(i==y) {
						return 1;
					}
					que.add(i);
					visit[i]=true;
				}
			}
		}
		
		return 0;
	}
}

