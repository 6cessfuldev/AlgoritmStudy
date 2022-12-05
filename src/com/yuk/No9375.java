package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			HashMap<String, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] strArr = br.readLine().split(" ");
				map.put(strArr[1],map.getOrDefault(strArr[1], 0)+1);
			}		
			
			int[] arr = new int[map.size()];
			int i = 0;
			for (String str : map.keySet()) {
				arr[i++] = map.get(str);
			}
		}
	}
}
