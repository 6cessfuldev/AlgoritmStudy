package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class No1931 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Mt> list = new ArrayList<>();
		
		while(N-- > 0) {
			String[] strArr =br.readLine().split(" ");
			int x = Integer.parseInt(strArr[0]);
			int y = Integer.parseInt(strArr[1]);
			list.add(new Mt(x,y));
		}
		
		list.sort(new Comparator<Mt>() {

			@Override
			public int compare(Mt o1, Mt o2) {
				if(o1.y==o2.y) {
					return o1.x-o2.x;
				}
				return o1.y-o2.y;
			}
		});
		
		int cnt = 0;
		int pre = 0;
		while(true) {
			int endTime = list.get(pre).y;
			cnt++;
			boolean flag = false;
			for(int i=pre+1; i<list.size(); i++) {
				if(list.get(i).x>=endTime) {
					pre=i;
					flag = true;
					break;
				}
			}
			if(!flag) break;
		}
		System.out.println(cnt);		
	}
}

class Mt {
	int x;
	int y;
	
	public Mt(int x, int y) {
		this.x = x;
		this.y = y;
	}
}