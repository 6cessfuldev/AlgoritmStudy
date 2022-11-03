package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.text.Document;

public class No1697 {

	static int N;
	static int K;
	static int[] map;
	
	public static int inf(int k) {
		
		if(N==k) return 0;
		
		if(k%2 ==0 ) {
			i(k < 100000)
			return Math.min(inf(k-1), Math.min(inf(k/2),inf(k+1)))+1;
		}else {
			return Math.min(inf(k+1), inf(k-1))+1;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		System.out.println(inf(K));		
	}
}
