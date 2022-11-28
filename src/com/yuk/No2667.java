package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coor_2677 {
	
	int x;
	int y;
	
	public Coor_2677(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class No2667 {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] arrX = {0, 1, 0, -1};
	static int[] arrY = {1, 0, -1, 0};
	static int cnt;
	
	public static int bfs(int a, int b) {
		
		int sum = 1;
		
		visit[a][b] = true;
		Coor_2677 co = new Coor_2677(a, b);
		Queue<Coor_2677> queue = new LinkedList<>();
		queue.add(co);
		cnt++;
		
		while(!queue.isEmpty()) {
			
			Coor_2677 tmp = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int x = tmp.x+arrX[i];
				int y = tmp.y+arrY[i];
				
				if(x>0 && x<=N && y>0 && y<=N ) {					
					if(map[x][y]==1 && !visit[x][y]) {
						visit[x][y] = true;
						sum++;
						queue.add(new Coor_2677(x, y));
					}
				}		
			}
		}
		
		return sum;
		
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visit = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j]=str.charAt(j-1)-48;
			}
		}
		
//		for (int i = 1; i < N; i++) {
//			for (int j = 1; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j]==1 && !visit[i][j]) {
					list.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(list);
		
		sb.append(cnt).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);

	}

}
