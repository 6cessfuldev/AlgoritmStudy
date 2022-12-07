package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class No14425 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		HashMap<String, Integer> S = new HashMap<>();
		while(N-- > 0) {
			S.put(br.readLine(), 0);
		}
		int cnt = 0;
		while(M-- > 0) {
			String str = br.readLine();
			if(S.containsKey(str)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
		
		
	}

}
