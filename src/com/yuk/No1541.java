package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1541 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		StringTokenizer stk = new StringTokenizer(str,"-+");
		ArrayList<Integer> numList = new ArrayList<>();
		ArrayList<Character> opList = new ArrayList<>();
		
		while(true) {
			String tk = stk.nextToken();
			int intTk = Integer.parseInt(tk);
			numList.add(intTk);
			
			if(!stk.hasMoreTokens()) break;
			
			char op = str.charAt(tk.length()); 
			opList.add(op);
			
			str=str.substring(tk.length()+1);	
		}
		
		int cnt = -1; 
		for (int i = 0; i < opList.size(); i++) {
			if(opList.get(i)=='-') {
				cnt = i;
				break;
			}
		}
		
		int sum = 0;
		if(cnt == -1) {
			for (int i = 0; i < numList.size(); i++) {
				sum += numList.get(i);
			}
		} else {
			for (int i = 0; i < numList.size(); i++) {
				if(i<=cnt) {
					sum += numList.get(i);
				} else {
					sum -= numList.get(i);
				}
			}
		}
		System.out.println(sum);
	}
}
