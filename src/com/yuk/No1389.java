package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1389 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		boolean[] visit = new boolean[N];
		
		//map 초기화
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = 987654321;
				if(i==j) map[i][j]=0;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b= Integer.parseInt(str.nextToken());	
			map[a-1][b-1]=1;
			map[b-1][a-1]=1;
		}
		
		//플로이드 와샬 알고리즘
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > map[i][k]+map[k][j]) {
						map[i][j]=map[i][k]+map[k][j];
					}
				}
			}
		}
		
		int res = 987654321;
		int idx = -1;
		
		for (int i = 0; i < map.length; i++) {
			int sum = 0;
			for (int j = 0; j < map[i].length; j++) {
				sum+=map[i][j];
			}
			
			if(res>sum) {
				res = sum;
				idx=i;
			}
		}
		
		System.out.println(idx+1);		
		
	}
}
