package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11659 {
	
	static int[] arr;
	static int[] prefix;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] strArr = br.readLine().split(" ");
		arr = new int[Integer.parseInt(strArr[0])];
		prefix = new int[arr.length+1];
		
		String[] strArr2 = br.readLine().split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strArr2[i]);
		}
		
		for (int i = 1; i <= arr.length; i++) {
			prefix[i] = prefix[i-1]+arr[i-1];
		}
	
		int cnt = Integer.parseInt(strArr[1]);
		while (cnt-- >0) {
			
			String[] strArr3 = br.readLine().split(" ");
			
			int a = Integer.parseInt(strArr3[0]);
			int b = Integer.parseInt(strArr3[1]);
	
			int sum = 0;

			sum = prefix[b]-prefix[a-1];
			
			sb.append(sum).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}
