package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class No2609 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);

		int common_divisor = 0;
		for (int i = 1; i <= N; i++) {
			if(N%i == 0 && M%i==0) {
				common_divisor = i;
			}
		}
		
		int common_factor = 0;
		for (int i = 1; i <= N; i++) {
			if((M*i)%N == 0) {
				common_factor = M*i;
				break;
			}
		}
		
		System.out.println(common_divisor);
		System.out.println(common_factor);
		
		
	}

}
