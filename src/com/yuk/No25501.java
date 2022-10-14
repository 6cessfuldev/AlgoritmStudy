package com.yuk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No25501 {
	
	static int cnt;

	public static int recursion(String s, int l, int r){
		cnt++;
		if(l >= r) return 1;
		else if(s.charAt(l) != s.charAt(r)) return 0;
		else return recursion(s, l+1, r-1);
	}	
	
	public static int isPalindrome(String s){
		return recursion(s, 0, s.length()-1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			int res = isPalindrome(str);
			
			bw.write(res+" "+cnt+"\n");
			cnt = 0;
		}
		
		bw.flush();
		bw.close();
	}

}
