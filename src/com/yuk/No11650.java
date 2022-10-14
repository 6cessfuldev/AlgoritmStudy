package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Coor implements Comparable<Coor>{
	int x;
	int y;
	
	public Coor(int x, int y) {
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
	public int compareTo(Coor o) {

		if(this.x != o.getX()) {
			return this.x - o.getX();
		} else {
			return this.y - o.getY();
		}		
	}	
}

public class No11650 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Coor> list = new ArrayList<>();
		
		while(N-- > 0) {
			String[] strArr = br.readLine().split(" ");
			Coor co = new Coor(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
			list.add(co);
		}

		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getX()+ " "+list.get(i).getY());
		}
		
	}

}
