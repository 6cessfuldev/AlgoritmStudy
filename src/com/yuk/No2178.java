package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class No2178 {

	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visit;
	static int[][] min;
	static int[] arrX = {-1, 0, 1, 0};
	static int[] arrY = {0, -1, 0, 1};
	static Queue<Xy> queue = new LinkedList<Xy>();
	
	public static void bfs() {
		
		queue.add(new Xy(0,0));
		visit[0][0]=true;
		min[0][0]=1;

		while(!queue.isEmpty()) {
			
			Xy a = queue.poll();
			
			for(int i=0; i<4; i++) {
				
				int tmpX = a.x+arrX[i];
				int tmpY = a.y+arrY[i];
				
				if(tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<M && map[tmpX][tmpY]=='1' &!visit[tmpX][tmpY]) {
					queue.add(new Xy(tmpX,tmpY));
					visit[tmpX][tmpY]=true;
					min[tmpX][tmpY] = min[a.x][a.y]+1;
					
					if(tmpX==N-1 && tmpY==M-1) {
						System.out.println(min[tmpX][tmpY]);
					}
				}
			}
		}
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
		
		bfs();
		
	}
}

class Xy {
	int x;
	int y;
	int count;
	
	public Xy(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
