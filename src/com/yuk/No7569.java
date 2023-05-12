package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No7569 {
	
	static int M;
	static int N;
	static int H;
	static int[][][] map;
	static boolean[][][] visit;
	static int[] arrx = {1, -1, 0, 0, 0, 0}; 
	static int[] arry = {0, 0, 1, -1, 0, 0};
	static int[] arrz = {0, 0, 0, 0, 1, -1};
	
	static class Tomato{
		int x;
		int y;
		int z;
		int day;
		
		public Tomato(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}

		@Override
		public String toString() {
			return "Tomato [x=" + x + ", y=" + y + ", z=" + z + ", day=" + day + "]";
		}
	}
	
	static int bfs() {
		
		int rs =0;
		
		Queue<Tomato> queue = new LinkedList<Tomato>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k] == 1 ) {
						queue.add(new Tomato(i,j,k,0));
						visit[i][j][k] = true;
						
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			
			Tomato tmp = queue.poll();
			rs = Math.max(tmp.day,rs);
			
			for (int i = 0; i < 6; i++) {
				
				int x =tmp.x+ arrx[i];
				int y =tmp.y+ arry[i];
				int z =tmp.z+ arrz[i];
				
				
				if(x>=0 && x<H && y>=0 && y<N && z>=0 && z<M && !visit[x][y][z]) {
					visit[x][y][z] = true;
					if(map[x][y][z]==0) {
						map[x][y][z] = 1;
						queue.add(new Tomato(x,y,z,tmp.day+1));		
					}
				}
			}
		}
		
		return rs;
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		M = Integer.parseInt(strArr[0]);
		N = Integer.parseInt(strArr[1]);
		H = Integer.parseInt(strArr[2]);

		map = new int[H][N][M];
		visit = new boolean[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				String[] str = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(str[k]);
				}
			}
		}
		
		//1. 이미 토마토가 익어있는 상태 => 0
		//처음부터 1과 -1 로만 구성되어 있는 상태
		boolean flag = false;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k] == 0) {
						flag = true;
					}
				}
			}
		}
		if(!flag) {
			System.out.println(0);
			return;
		}
		
		int rs = bfs();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(rs);
		

	}

}
