package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5597 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[31];
		
		for (int i = 0; i < 28; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[n] = true;
		}
		
		for (int i = 1; i < arr.length; i++) {
			if(!arr[i]) System.out.println(i);
		}
		
	}
}
