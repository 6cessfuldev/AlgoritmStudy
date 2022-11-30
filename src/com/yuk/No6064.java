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
			int x = Integer.parseInt(strArr[2]);
			int y = Integer.parseInt(strArr[3]);
			
			int gcd = 0;
			if(M>N) {
				gcd = gcd(M,N); 
			}else {
				gcd = gcd(N,M);
			}
			int lcm = M*N/gcd;
			
			int[] arrx = new int[lcm+1];
			int[] arry = new int[lcm+1];			
			
			for (int i = 1; i <= lcm; i++) {
				arrx[i] = (i-1)%N+1;
			}

//			for (int i = 0; i < arrx.length; i++) {
//				System.out.print(i + " " +arrx[i]+" ");
//			}
			
			int rs = 0;
			for (int i = x; i < arrx.length; i+=M) {
				if(arrx[i] == y) {
					rs = i;
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
