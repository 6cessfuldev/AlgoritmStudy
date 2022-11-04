package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1697 {

	static int N;
	static int K;
	static int[] visit = new int[100001];
	
	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		//매개변수 입력
		queue.offer(num);
		visit[num]=1;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			//큐에서 나오는 숫자를 기준으로 n+1, n-1, 2n 값으로 
			for (int i = 0; i < 3; i++) {
				int next;
				
				if(i==0) {
					next = n+1;
				}else if(i==1) {
					next = n-1;
				}else {
					next = n * 2;
				}
				// 각 n에 해당되는 n+1, n-1, 2n의 값이 K(목표)와 같다면 스탑
				if(next == K) {
					System.out.println(visit[n]);
					return;
				}
				
				if(next >= 0 && next < visit.length && visit[next] == 0) {
					queue.add(next);
					visit[next] = visit[n]+1;
				}
			}
		}	
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		if(N==K) {
			System.out.println(0); 
			return;
		}
		
		bfs(N);
	}
}
