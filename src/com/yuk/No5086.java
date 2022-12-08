package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class No5086 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String[] strArr = br.readLine().split(" ");
			int m = Integer.parseInt(strArr[0]);
			int n = Integer.parseInt(strArr[1]);
			if(m == 0 && m ==n) break;
			
			String rs = "";
			if(n%m ==0) rs = "factor";
			else if(m%n ==0) rs = "multiple";
			else rs = "neither";
			
			sb.append(rs+"\n");
		}
		
		System.out.println(sb);
	}
}
