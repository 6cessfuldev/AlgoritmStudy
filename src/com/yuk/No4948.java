package com.yuk;

import java.util.Scanner;

public class No4948 {
	
	static boolean[] prime = new boolean[10001]; 

	public static void main(String[] args) {
		
		get_prime();
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		StringBuilder sb = new StringBuilder();
	
		while(T-- > 0 ) {
			int n = scan.nextInt();
			
			for (int i = n/2; i > 0; i--) {
				if(!prime[i] && !prime[n-i]) {
					sb.append(i+" "+(n-i)+"\n");
					break;
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void get_prime() {
		
		prime[0] = prime[1] = true;
		
		for (int i = 2; i < prime.length; i++) {
			if(prime[i] == true) continue;
			
			for (int j = i*i; j < prime.length; j=j+i) {
				prime[j] = true;
			}
		}
		
	}
}
