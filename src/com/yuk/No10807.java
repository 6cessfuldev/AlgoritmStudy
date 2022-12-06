package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No10807 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < strArr.length; i++) {
			int num = Integer.parseInt(strArr[i]);
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		System.out.println(map.getOrDefault(Integer.parseInt(br.readLine()), 0));

	}

}
