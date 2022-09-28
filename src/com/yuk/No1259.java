package com.yuk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class No1259 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		String str = "";
		ArrayList<String> list = new ArrayList<>();
		while(true){
			boolean flag = true;			
			str = br.readLine();
			if(str.equals("0")) {
				break;
			}
			 
			char[] chArr = new char[str.length()];
			//char array 만들기
			for (int i = 0; i < chArr.length; i++) {
				chArr[i] = str.charAt(i);
			}
			//양끝부터 차례대로 비교하기
			for (int i = 0; i < chArr.length; i++) {					
				if(chArr[i] != chArr[chArr.length-1-i]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				list.add("yes");
			} else {
				list.add("no");
			}
			 
		};
		
		for (String string : list) {
			bw.write(string + "\n");
		}
		
		bw.flush();					
		bw.close();
	}
}