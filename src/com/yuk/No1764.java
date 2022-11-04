package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1764 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		ArrayList<String> unheard = new ArrayList<>();
		ArrayList<String> unseen = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			unheard.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			unseen.add(br.readLine());
		}
		
		ArrayList<String> unseenheard = new ArrayList<>();
		for (String name : unseen) {
			if(unheard.contains(name)){
				unseenheard.add(name);
			}
		}
		
		Collections.sort(unseenheard);
		System.out.println(unseenheard.size());
		for (String name : unseenheard) {
			System.out.println(name);
		}
	}

}
