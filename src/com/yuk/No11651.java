package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Coo implements Comparable<Coo>{
	int x;
	int y;
	
	public Coo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int compareTo(Coo o) {

		if(this.y != o.getY()) {
			return this.y - o.getY();
		} else {
			return this.x - o.getX();
		}		
	}	
}

public class No11651 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Coo> list = new ArrayList<>();
		
		while(N-- > 0) {
			String[] strArr = br.readLine().split(" ");
			Coo co = new Coo(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
			list.add(co);
		}

		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getX()+ " "+list.get(i).getY());
		}
		
	}

}
