package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1107 {
	
	/* 1. +- 버튼으로만 이동하는 경우
	 * 2. 숫자 버튼이 고장 나서 그 주변의 숫자에서 +-버튼으로 추가적으로 이동하는 경우 
	 * 3. 숫자 버튼으로 바로 갈 수 있는 경우 */	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String[] strArr = null;
		if(M >0) {
			strArr = br.readLine().split(" ");
		}
		boolean[] broken = new boolean[10];
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(strArr[i]);
			broken[n] = true;
		}
		
		int min = Math.abs(N-100);
		loop :
		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			//문자열로 바꿔서 각 자리수가 버튼으로 누를 수 있는지 확인 고장나서 안되면 제외
			for (int j = 0; j < str.length(); j++) {
				if( broken[Integer.valueOf(str.charAt(j)-48)]) {
					continue loop;
				}
			}
			
			int rs = Math.abs(i-N)+str.length();
			min = Math.min(min, rs);			
		}		
		System.out.println(min);
	}
}
