package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2231 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());		

		int min = Integer.MAX_VALUE;
		for(int i = 1; i<n ; i++) {
			if(n == maker(i) && i == Math.min(i, min)) {
				min = i;
			}
		}
		if(min < n) {
			System.out.println(min);
		} else {
			System.out.println(0);
		}
		
	}
	
	public static int maker(int m) {
		
		int sum = m;
		do {
			sum += m%10;
			m /= 10;
		} while(m!=0);
		
		return sum;
	}

}
