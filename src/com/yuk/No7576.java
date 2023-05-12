package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class No7576 {
	
	static LinkedHashMap<Coor, Tomato> box = new LinkedHashMap<>();
	static HashSet<Coor> next = new HashSet<>();
	static boolean[][] visit;
	static int[] arrx = {0, 1, 0, -1};
	static int[] arry = {-1, 0, 1, 0};
	static int m;
	static int n;
	static int day;
	
	static class Coor {
		public int x;
		public int y;
		
		public Coor(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			Coor co = (Coor)obj;
			if(this.x == co.x && this.y == co.y) return true;
			return false;
		}
		
	    @Override
	    public int hashCode() {
	        int result = (int)(x ^ (x >>> 32));
	        
	        result = 31 * result + (int)(x ^ (x >>> 32));
	        result = 31 * result + (int)(y ^ (y >>> 32));
	        
	        return result;
	    }
	}
	
	static class Tomato {
		Coor co;
		int visit;
		int status;
		
		public Tomato(int x, int y, int status) {
			this.co = new Coor(x, y);
			this.status = status;
		}
		
		public boolean getRipe() {
			if(status==0) {
				status=1;
				return true;
			}
			return false;
		}
		
		//익은 토마토면 주변을 익게 만들기
		public void nextRipe() {
			
			if(status != 1) return;
			
			for (int i = 0; i < 4; i++) {
				
				int tmX = co.x+arrx[i];
				int tmY = co.y+arry[i];
				
				if(tmX >= 0 && tmX < m && tmY>=0 && tmY< n) {
					
					Coor tmp = new Coor(tmX, tmY);
					next.add(tmp);
				}
			}
		}
		
		public int getStatus() {
			return status;
		}
	}
	
	public static boolean makeAllRipe() {
		
		for (Coor key : box.keySet()) {
			box.get(key).nextRipe();
		}
		
		boolean flag = false;
		for (Coor key : next) {
			if(box.get(key).getRipe()) flag = true;
		}
			
		if(flag) {
			return true;
		}
		return false;

	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		//가로 길이
		m = Integer.parseInt(strArr[0]);
		//세로 길이
		n = Integer.parseInt(strArr[1]);
		
		visit = new boolean[m][n];
		
		//세로 길이
		for (int i = 0; i < n; i++) {
			
			String[] strArr1 = br.readLine().split(" ");
			
			//가로 길이
			for (int j = 0; j < m; j++) {
				Tomato tm = new Tomato(j,i,Integer.parseInt(strArr1[j]));
				Coor co = new Coor(j,i);
				box.put(co, tm);
			}
		}
		
		boolean flag = true;
		for (Coor key : box.keySet()) {
			if(box.get(key).getStatus() != 0) {
				flag = false;
				break;
			}
		}
	
		if(flag) {
			System.out.println(0);
			return;
		}
		
		int cnt = 0;
		while(makeAllRipe()) {
			cnt++;
			// test log
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					Coor co = new Coor(j, i);
					 System.out.print( box.get(co).status +" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		boolean rsflag = true;
		for (Coor key : box.keySet()) {
			if(box.get(key).getStatus()==0) {
				rsflag = false;
				break;
			}
		}
		
		// test log
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Coor co = new Coor(j, i);
				 System.out.print( box.get(co).status +" ");
			}
			System.out.println();
		}
		
		if(rsflag) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
		
		
		
	}

}


