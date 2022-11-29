package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5525_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		String P ="";
		for (int i = 0; i < N; i++) {
			P+="OI";
		}
		P = "I"+P;
		
		int cnt = 0;
		for (int i = 0; i < M-(2*N+1); i++) {
			if(S.charAt(i)=='I') {
				if(S.substring(i, i+2*N+1).equals(P)) {
					cnt++;
					i++;
				}
				
			}
		}
		
		System.out.println(cnt);
	}

}
