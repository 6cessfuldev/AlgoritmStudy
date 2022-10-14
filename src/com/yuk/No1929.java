package com.yuk;

import java.util.Scanner;

public class No1929 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int M = scan.nextInt();
		int N = scan.nextInt();
		
		boolean[] arr = new boolean[N+1];
		
		if(N == 2){
			
			System.out.println(2);
			
		} else if(N ==1) {

		} else {
			arr[1] = true;
			for (int i= 2; i <= Math.sqrt(N); i++) {
				
				if(arr[i] == true) continue;
				
				for (int j =i*i ; j < arr.length; j=j+i) {
					arr[j] = true;
				}
			}
			
			for (int i = M; i <= N; i++) {
				if(arr[i] == false) System.out.println(i);
			}
		}
	}
}
