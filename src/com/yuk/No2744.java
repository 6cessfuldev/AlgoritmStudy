package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2744 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String answer = "";
		
		for (char c : str.toCharArray()) {
			if(c == Character.toLowerCase(c)) {
				answer += Character.toUpperCase(c);
			}else {
				answer += Character.toLowerCase(c);
			}
		
		}
		
		System.out.println(answer);
		
		
	}
}
