package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Impl9019 {
	
	int[] arrA;
	int[] arrB;
	ArrayList<Character> order = new ArrayList<>();
	
	public Impl9019(int a, int b) {
		
	arrA = makeArray(a);
	arrB = makeArray(b);
	
	}
		
	public int[] getArrA() {
		return arrA;
	}
	
	public int[] getArrB() {
		return arrB;
	}
	
	public ArrayList<Character> getOrder(){
		return order;
	}
	
	public int[] makeArray(int a) {
		
		int[] rs = new int[4];
		
		for (int i = 0; i < rs.length; i++) {
			rs[rs.length-i-1] = a%10;
			a = a/10;
		}
		return rs;	
	}
	
	public boolean isEqual() {
		boolean flag = true;
		for (int i = 0; i < arrA.length; i++) {
			if(arrA[i] != arrB[i]) {
				flag = false;
			}
		}
		return flag;
	}
	
	public int getInt() {
		int rs = 0;
		int x = 1;
		for (int i = 0; i < arrA.length; i++) {
			rs += arrA[arrA.length-i-1]*x;
			x *= 10;
		}
		return rs;
	}
	
	public void addOrder(char c) {
		this.order.add(c);
	}
}

public class No9019 {
	
	static boolean[] visit;
	static char[] chars = {'D', 'S', 'L', 'R'};
	
	public static int D(int a) {
		if(2*a>9999) {
			return 2*a%10000;
		} else {
			return 2*a;
		}
	}
	
	public static int S(int a) {
		if(a==0) {
			return 9999;
		}else {
			return a-1;
		}
	}
	
	public static int L(int a) {
		int[] arr = makeArray(a);
		int tmp = arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[3] = tmp;
		return getInt(arr);
	}
	
	public static int R(int a) {
		int[] arr = makeArray(a);
		int tmp = arr[3];
		for (int i = 3; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = tmp;
		return getInt(arr);
	}
	
	public static int[] makeArray(int a) {
		
		int[] rs = new int[4];
		for (int i = 0; i < rs.length; i++) {
			rs[rs.length-i-1] = a%10;
			a = a/10;
		}
		return rs;	
	}
	
	public static int getInt(int[] arr) {
		
		int rs = 0;
		int x = 1;
		for (int i = 0; i < arr.length; i++) {
			rs += arr[arr.length-i-1]*x;
			x *= 10;
		}
		return rs;
	}
	
	public static ArrayList<Character> bfs(int a, int b) {
		
		Impl9019 impl = new Impl9019(a, b);
		if(impl.isEqual()) return impl.order; 
		Queue<Impl9019> queue = new LinkedList<>();
		visit[impl.getInt()] = true;
		queue.add(impl);
		
		while(!queue.isEmpty()) {
			
			Impl9019 tmp = queue.poll();
//			System.out.println("========");
//			System.out.println(tmp.getInt() + " => "+b);
//			System.out.println(tmp.order);
//			System.out.println("========");
			
			if(tmp.isEqual()) {
				return tmp.order;
			}
			
			for (int i = 0; i < 4; i++) {
				Impl9019 next = null;
				int rs = 0;
				if(i==0) {
					rs = D(tmp.getInt());
					if(!visit[rs]){
						visit[rs]=true;
						next = new Impl9019(rs, b);
						next.order.addAll(tmp.order);
						next.addOrder('D');
						queue.add(next);
					}
				}else if(i==1) {
					rs = S(tmp.getInt());
					if(!visit[rs]){
						visit[rs]=true;
						next = new Impl9019(rs, b);
						next.order.addAll(tmp.order);
						next.addOrder('S');
						queue.add(next);
					}
				}else if(i==2) {
					rs = L(tmp.getInt());
					if(!visit[rs]){
						visit[rs]=true;
						next = new Impl9019(rs, b);
						next.order.addAll(tmp.order);
						next.addOrder('L');
						queue.add(next);
					}
				}else {
					rs = R(tmp.getInt());
					if(!visit[rs]){
						visit[rs]=true;
						next = new Impl9019(rs, b);
						next.order.addAll(tmp.order);
						next.addOrder('R');
						queue.add(next);
					}
				}
			}
		}
		return null;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- >0) {
			
			String[] str = br.readLine().split(" ");
			int A = Integer.parseInt(str[0]);
			int B = Integer.parseInt(str[1]);
		
			visit =  new boolean[10000];
			ArrayList<Character> list =  bfs(A,B);
			for (Character c : list) {
				sb.append(c);
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}

}
