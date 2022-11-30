package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5525 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		char[] chArr = S.toCharArray();
		int[] menu = new int[M];
		for (int i = 1; i < chArr.length-1; i++) {
			if(chArr[i]=='O' && chArr[i+1]=='I') {
				menu[i+1]=menu[i-1]+1;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < menu.length; i++) {
			if(menu[i]>=N) {
				if(chArr[i-2*N]=='I') {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	
}
