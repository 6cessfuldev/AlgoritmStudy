package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260 {
	
	static int N;
	static int M;
	static int Y;
	static boolean[] visit;
	static int[][] map;
	
	public static void dfs(int i) {
	
		visit[i]=true;
		System.out.print(i+1+" ");
		for (int j = 0; j < map[i].length; j++) {
			if(map[i][j]==1 && !visit[j]) {
				dfs(j);
			}
		}
	}
	
	public static void bfs(int i) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visit[i]=true;
		System.out.print(i+1+" ");
		while(!queue.isEmpty()) {
			
			int a = queue.poll();
			
			for (int j = 0; j < N; j++) {
				if(map[a][j]==1 && !visit[j]) {
					visit[j] = true;
					System.out.print(j+1+" ");
					queue.add(j);
				}
			} 	
		}		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visit = new boolean[N];
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1]=1;
			map[b-1][a-1]=1;
		}
		dfs(Y-1);
		System.out.println();
		visit = new boolean[N];
		bfs(Y-1);
	}
	

}
