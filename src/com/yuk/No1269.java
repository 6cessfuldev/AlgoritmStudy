package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiFunction;

public class No1269 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		HashMap<String, Integer> A = new HashMap<>();
		String[] strArr1 = br.readLine().split(" ");
		for (int i = 0; i < strArr1.length; i++) {
			A.put(strArr1[i], 1);
		}
		
		HashMap<String, Integer> B = new HashMap<>();
		String[] strArr2 = br.readLine().split(" ");
		for (int i = 0; i < strArr2.length; i++) {
			B.put(strArr2[i], 1);
		}

		for (String string : strArr2) {
			A.remove(string);
		}
		for (String string : strArr1) {
			B.remove(string);
		}
		System.out.println(A.size()+B.size());
	}

}
