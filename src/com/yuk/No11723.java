package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Impl11723 {
	HashSet<Integer> set = new HashSet<>();
	HashSet<Integer> fullset = new HashSet<>();
	
	public Impl11723() {
		for (int i = 1; i <= 20; i++) {
			fullset.add(i);
		}	
	}
	
	public void add(int n) {
		set.add(n);
	}
	
	public void remove(int n) {
		set.remove(n);
	}
	
	public int check(int n) {
		if(set.contains(n)) {
			return 1;
		}
		return 0;
	}
	
	public void toggle(int n) {
		if(set.contains(n)) {
			set.remove(n);
		} else {
			set.add(n);
		}
	}
	
	public void all() {
		set = fullset;
	}
	
	public void empty() {
		set.clear();
	}
}

public class No11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		Impl11723 imp = new Impl11723();
		
		while(M-- > 0) {
			String[] str = br.readLine().split(" ");
			switch(str[0]) {
			case "add" :
				imp.add(Integer.parseInt(str[1]));
				break;
			case "remove" :
				imp.remove(Integer.parseInt(str[1]));
				break;
			case "check" :
				sb.append(imp.check(Integer.parseInt(str[1]))).append("\n");
				break;
			case "toggle" :
				imp.toggle(Integer.parseInt(str[1]));
				break;
			case "all" :
				imp.all();
				break;
			case "empty" :
				imp.empty();
				break;
			}
		}
		
		System.out.println(sb);		

	}

}
