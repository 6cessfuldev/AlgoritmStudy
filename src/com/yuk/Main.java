package com.yuk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		//길이 비교		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length()-o2.length();
				}
		
			}
		});
		
		bw.write(arr[0]+"\n");
		for (int i = 1; i < arr.length; i++) {
			if(!arr[i].equals(arr[i-1])) {
				bw.write(arr[i]+"\n");
			}
		}
		
		bw.flush();					
		bw.close();
	}
}