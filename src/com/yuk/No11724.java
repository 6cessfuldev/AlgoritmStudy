package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class No11724 {

	static int N;
	static int M;
	static int[][] map;
	static boolean[] visit;

	public static void bfs(int x) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		visit[x] = true;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (map[tmp][i] == 1 && !visit[i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < M; i++) {
			String[] strArr = br.readLine().split(" ");
			int a = Integer.parseInt(strArr[0]);
			int b = Integer.parseInt(strArr[1]);
			map[a][b] = 1;
			map[b][a] = 1;
			set.add(a);
			set.add(b);
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				bfs(i);
				cnt++;
			}

		}
		System.out.println(cnt);

	}

}
