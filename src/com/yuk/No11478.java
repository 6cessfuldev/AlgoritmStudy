package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No11478 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j < str.length()-i+1; j++) {
				map.put(str.substring(j,j+i), 1);
			}
		}
		
		System.out.println(map.size());
		
	}

}
