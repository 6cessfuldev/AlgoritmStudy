package com.yuk;

import java.util.Scanner;

public class No1676 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int cnt = 0;
		for (int i = 0; i <= N; i++) {
			if(i>0 && i%5==0) {
				int tmp = i;
				while(true) {
					tmp = tmp/5;
					cnt++;
					if(tmp%5!=0) break;
				}
			}
		}
		System.out.println(cnt);
	}
}