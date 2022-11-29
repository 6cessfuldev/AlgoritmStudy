package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5525 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		int[] arr = getArray(S);
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) {
				sum+= arr[i]-N+1;
			}
		}
		
		System.out.println(sum);
		
	}
	
	public static int[] getArray(String S) {
		
		int[] arr = new int[S.length()];
		int k =0;
		int p =0;
		
		for (int i = 0; i < S.length()-2; i++) {
			if(S.substring(i, i+3).equals("IOI")) {
				p++;
				i++;
			}else {
				if(p>0) {
					arr[k++]=p;
					p=0;
				}else {
					arr[k++]=0;					
				}
			}
		}
		if(p>0) {
			arr[k]=p;
		}
		
		return arr;
	}
}
