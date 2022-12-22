package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;

public class No11047 {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		int n = Integer.parseInt(strArr[0]);
		int k = Integer.parseInt(strArr[1]);
		
		Stack<Integer> stack = new Stack<>();
		
		while(n-- > 0) {
			
			stack.add(Integer.parseInt(br.readLine())); 
			
		}
		int cnt = 0;
		while(k != 0) {
			int coin = stack.pop();
			if(k>=coin) {
				cnt += k/coin;
				k = k%coin;
			}
		}
		
		System.out.println(cnt);
	}

}
