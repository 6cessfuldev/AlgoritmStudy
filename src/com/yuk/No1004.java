package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Impl1004 {
	
	int x;
	int y;
	int r;
	
	public Impl1004(int x, int y, int r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public boolean isIn(int x1, int y1) {
		if((x1-x)*(x1-x)+(y1-y)*(y1-y) < r*r) {
			return true;
		}

		return false;
	}
}

public class No1004 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			
			String[] strArr = br.readLine().split(" ");
			int x1 = Integer.parseInt(strArr[0]);
			int y1 = Integer.parseInt(strArr[1]);
			int x2 = Integer.parseInt(strArr[2]);
			int y2 = Integer.parseInt(strArr[3]);
			
			int n = Integer.parseInt(br.readLine());
			ArrayList<Impl1004> list = new ArrayList<>();
			while(n-- > 0) {
				
				String[] strArr2 = br.readLine().split(" ");
				int x = Integer.parseInt(strArr2[0]);
				int y = Integer.parseInt(strArr2[1]);
				int r = Integer.parseInt(strArr2[2]);
				Impl1004 imp = new Impl1004(x,y,r);
				list.add(imp);
			}
			//출발점이 속해 있는 행성계 + 도착점이 속해 있는 행성계 - 둘 다 속해 있는 행성계
			int startCnt = 0;
			int endCnt = 0;
			
			for (int i = 0; i < list.size(); i++) {
				if( !(list.get(i).isIn(x1, y1)&&list.get(i).isIn(x2, y2)) && (list.get(i).isIn(x1, y1)||list.get(i).isIn(x2, y2)) )  {
					startCnt++;

				}
			}

			
			sb.append(startCnt + "\n");
		}
		System.out.println(sb);
	}
	
	
}
