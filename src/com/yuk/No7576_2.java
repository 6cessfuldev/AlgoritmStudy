package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No7576_2 {

	static int m;
	static int n;
	static Tomato[][] map;
	static boolean[][] visit;
	static int[] arrX = {0,1,0,-1};
	static int[] arrY = {1,0,-1,0};
	static ArrayList<Tomato> box = new ArrayList<>();
	
	static void bfs() {
		
		Queue<Tomato> que = new LinkedList<>();
		
		//map이 1인 경우 사방의 좌표를 익어야 할 que에 저장
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j].status==1) {
					Tomato tm = new Tomato(i,j,0,1);
					que.add(tm);
					visit[i][j]=true;
				}
			}
		}
		
		while(!que.isEmpty()) {
			
			Tomato tom = que.poll();
			for (int i = 0; i < 4; i++) {
				int tmpx=tom.x+arrX[i];
				int tmpy=tom.y+arrY[i];
				
				if(tmpx>=0 && tmpx<n && tmpy>=0 && tmpy<m &&!visit[tmpx][tmpy]) {
					visit[tmpx][tmpy]=true;
					if(map[tmpx][tmpy].status==0) {
						Tomato tm = new Tomato(tmpx, tmpy,tom.day+1,1);
						que.add(tm);
						map[tmpx][tmpy].status=1;
						map[tmpx][tmpy].day=tom.day+1;
					}
				}
				
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		m = Integer.parseInt(strArr[0]);
		n = Integer.parseInt(strArr[1]);
		
		map=new Tomato[n][m];
		visit=new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] strArr2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				Tomato tm = new Tomato(i,j,0,Integer.parseInt(strArr2[j]));
				map[i][j]=tm;
						
			}
		}
		
		bfs();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j].status==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(max < map[i][j].day) {
					max = map[i][j].day;
				}
			}
		}
		System.out.println(max);
		
	
	}

	static class Tomato {
		int x;
		int y;
		int day;
		int status;
		
		public Tomato(int x, int y, int day, int status) {
			this.x = x;
			this.y = y;
			this.day = day;
			this.status = status;
		}
	}
}
