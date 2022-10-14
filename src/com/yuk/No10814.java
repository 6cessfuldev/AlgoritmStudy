package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No10814 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		ArrayList<User> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String[] strArr = br.readLine().split(" ");
			User user = new User(Integer.parseInt(strArr[0]), strArr[1]);
			list.add(user);
		}
		
		Collections.sort(list);

		for (User user : list) {
			System.out.println(user.num + " " + user.name);
		}
	}

}

class User implements Comparable<User> {
	
	int num;
	String name;
	int cnt = 1;
	
	public User(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		cnt++;
	}

	@Override
	public int compareTo(User o) {
		
		if(this.num == o.num) {
			return this.cnt - o.cnt; 
		} 
		return this.num - o.num;
	}
	
}
