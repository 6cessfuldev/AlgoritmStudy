package com.yuk;

import java.util.Scanner;

public class No1978 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		
		if(N==1) {
		}else {
			while(N!=1) {
				for (int i = 2; i <= N; i++) {
					if(N%i == 0) {
						System.out.println(i);
						N= N/i;
						break;
					}
				}
			}
		}
	}

}
