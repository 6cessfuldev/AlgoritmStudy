package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1002 {
	
	/*
	 * 1. 접점이 무한대일 경우
	 * 중심점도 같고 길이도 같다
	 * 
	 * 2. 접점이 하나인 경우
	 * 2-1 내접하고 r2 = 두점의 거리 + r1
	 * 2-2 외접하고 r2+r1 = 두점의 거리
	 * 
	 * 3. 접점이 하나도 없는 경우
	 * 3-1 내부에 있고 r2 > 두점의 거리 + r1
	 * 3-2 외부에 있고 두점의 거리 > r2+r1
	 * 
	 * 4. 접점이 두개인 경우
	 * 나머지 
	*/
	
	static int countR(int x1, int y1, int r1, int x2, int y2, int r2) {
	
		int x = x1-x2;
		int y = y1-y2;
		int dist = x*x+y*y;
		int r = r1+r2;
		
		//구심점이 같은 경우
		if(x1==x2 && y1==y2) {
//			System.out.println("case1");
			if(r1==r2) return -1;
			else return 0;
		}else if(r2*r2 -2*r1*r2+ r1*r1 == dist || r2*r2 +2*r1*r2+r1*r1 == dist) {
//			System.out.println("case2");
			return 1;
		}else if(r2*r2 -2*r1*r2 +r1*r1 > dist || r2*r2 +2*r1*r2+r1*r1 < dist) {
//			System.out.println("case3");
			return 0;
		}
		return 2;

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- >0) {
			
			String[] strArr = br.readLine().split(" ");
			int x1 = Integer.parseInt(strArr[0]);
			int y1 = Integer.parseInt(strArr[1]);
			int r1 = Integer.parseInt(strArr[2]);
			int x2 = Integer.parseInt(strArr[3]);
			int y2 = Integer.parseInt(strArr[4]);
			int r2 = Integer.parseInt(strArr[5]);
			if(r1<=r2) sb.append(countR(x1,y1,r1,x2,y2,r2)).append("\n");
			else sb.append(countR(x2,y2,r2,x1,y1,r1)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	
}
