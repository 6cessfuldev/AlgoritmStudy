package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
		int k = Integer.parseInt(br.readLine());
		
		while(k-- > 0) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(!stack.isEmpty()) {
					stack.pop();
				} else {
					stack.add(0);
				}
			} else {
				stack.add(input);
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum+= stack.pop(); 
		}
		
		System.out.println(sum);

	}

}

