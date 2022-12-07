package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1002 {
	
	//1. 두 터렛 사이의 거리 > r1+r2 일 경우 접점은 없다.
	//2. r2 > 두 터렛 사이의 거리 + r1 일 경우 접점은 없다.
	//3. 두 터렛 사이의 거리 == r1+r2 일 경우 두 터렛의 사이의 직선과 원의 접점 한 점에서 만난다.
	//4. 두 터렛 사이의 거리 < r1+r2 일 경우 접점은 두개
	//5. 두 터렛 사이의 거리가 0일 경우 접점은 무한대
	
	//1. 원1 안에 원2가 있거나 원2 안에 원1이 있는 경우
	// 1-1 r1> r2인 경우 
	// 1-1-1 r1 > 두 터렛 사이의 거리 + r2 일 경우 접점은 없다.
	// 1-1-2 r1 == 두 터렛 사이의 거리 +r2 일 경우 접점은 하나
	// 1-1-3 r1 < 두 터렛 사이의 거리 + r2 일 경우 접점은 두개
	
	//2. 서로 밖에 있는 경우 
	//2-1 두 터렛 사이의 거리 > r1+r2 일 경우 접점은 없다.
	//2-2 두 터렛 사이의 거리 == r1+r2 일 경우 두 터렛의 사이의 직선과 원의 접점 한 점에서 만난다.
	//2-3 두 터렛 사이의 거리 < r1+r2 일 경우 접점은 두개
	
	//3. 한 점에서 만나는 경우
	// r1 == r2 이면 무한대
	// r1 != r2 이면 0개
	static int countR(int x1, int y1, int r1, int x2, int y2, int r2) {
	
		int x = x1-x2;
		int y = y1-y2;
		int dist = x*x +y*y;
		int r = r1+r2;
		
		//구심점이 같은 경우
		if(x1==x2 && y1==y2) {
			if(r1==r2) return -1;
			else return 0;
		}
		
		//한 원 안에 다른 원이 들어 있는 경우
		if(dist<r1*r1 || dist<r2*r2) {
			if(r1>=r2) {
				//큰 원 안에 포함되어 있는 경우
				if(dist+r2*r2 < r1*r1) {
					return 0;
					//큰 원 테투리와 맞닿은 경우
				}else if(dist+r2*r2==r1*r1) {
					return 1;
					//큰 원 안에 중심은 있지만 테투리 밖에 원이 일부 나간 경우
				}else if(dist+r2*r2 >r1*r1) {
					return 2;
				}							
			}
		}
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
			
			sb.append(countR(x1,y1,r1,x2,y2,r2)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	
}
