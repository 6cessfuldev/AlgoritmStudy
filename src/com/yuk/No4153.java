package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4153 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String[] strArr = br.readLine().split(" ");
			int a = Integer.parseInt(strArr[0]);
			int b = Integer.parseInt(strArr[1]);
			int c = Integer.parseInt(strArr[2]);
			if(a==0 && b==0 && c==0) break;
			
			int max = Math.max(a, b);
			max = Math.max(max, c);

			String rs = "";
			if(a==max) {
			
				if(a*a == b*b + c*c) {
					rs="right";
				} else {
					rs="wrong";
				}
				
			} else if(b==max) {
				
				if(b*b == a*a+c*c) {
					rs="right";
				} else {
					rs="wrong";
				}
			} else {
				if(c*c == b*b+a*a) {
					rs="right";
				} else {
					rs="wrong";
				}
			}
			
			sb.append(rs+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
