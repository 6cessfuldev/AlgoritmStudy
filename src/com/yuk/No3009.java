package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No3009 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> x = new HashMap<>();
		HashMap<String, Integer> y = new HashMap<>();
		for (int i = 0; i < 3; i++) {
			String[] strArr = br.readLine().split(" ");
			x.put(strArr[0], x.getOrDefault(strArr[0], 0)+1);
			y.put(strArr[1], y.getOrDefault(strArr[1], 0)+1);
		}
		
		for (String string : x.keySet()) {
			if(x.get(string) ==1) {
				System.out.print(string);
			}
		}
		System.out.print(" ");
		for (String string : y.keySet()) {
			if(y.get(string) ==1) {
				System.out.print(string);
			}
		}
		
		
	}

}
