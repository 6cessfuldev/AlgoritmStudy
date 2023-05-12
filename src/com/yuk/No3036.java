package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No3036 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int r = Integer.parseInt(br.readLine());
		
		int[] arr = new int[r];
		String[] strArr = br.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		
		for (int i = 1; i < r; i++) {
			int gcd = gcd(arr[0],arr[i]);
			if(gcd>1){
				System.out.println(arr[0]/gcd +"/"+arr[i]/gcd);
			}else {
				System.out.println(arr[0] +"/"+arr[i]);
			}
		}
	}
	
	public static int gcd(int p, int q) {
		
		if(q==0) return p;
		return gcd(q, p%q);
	}

}
