package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11729 { 
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	// 동판 세트가 출발하는 곳, 목적지
	static void hanoi(int n, int start, int end) {
		//System.out.println(n+"개가 "+start+"에서"+end+"로 이동 시작");
		//경유지의 위치
		int layover = 6-start-end;  
		
		if(n == 1) {
			sb.append(start + " "+end).append("\n");
			cnt++;
		}else if(n == 2) {
			sb.append(start + " "+layover).append("\n");
			sb.append(start + " "+end).append("\n");
			sb.append(layover + " "+end).append("\n");
			cnt += 3;
		}else {
			hanoi(n-1, start, layover);
		//	System.out.println(n+"짜리 큰 동판 "+start +"에서"+end+"로 이동");
			sb.append(start+" "+end).append("\n");
			cnt ++;
			hanoi(n-1, layover, end);
		}
		//System.out.println(n+"개가 "+start+"에서"+end+"로 이동 끝");

		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		hanoi(n, 1, 3);
		System.out.println(cnt);
		System.out.println(sb);

	}

}
