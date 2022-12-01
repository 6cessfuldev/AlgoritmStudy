package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No6064 {

	public static int gcd(int x, int y) {
		
		while(y != 0) {
			int r = x % y;
			x = y;
			y = r;
		}
		return x;	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			String[] strArr = br.readLine().split(" ");
			int M = Integer.parseInt(strArr[0]);
			int N = Integer.parseInt(strArr[1]);
			int x = Integer.parseInt(strArr[2])-1;
			int y = Integer.parseInt(strArr[3])-1;
			
			int gcd = 0;
			if(M>N) {
				gcd = gcd(M,N); 
			}else {
				gcd = gcd(N,M);
			}
			int lcm = M*N/gcd;
			
			int rs = 0;
			for (int i = x; i <= lcm; i+=M) {
				if(i%N == y) {
					rs = i+1;
					break;
				}
			}			
			
			if(rs==0) {
				sb.append("-1\n");
			}else {
				sb.append(rs+"\n");
			}	 
		}
		
		System.out.println(sb);
	}

}
