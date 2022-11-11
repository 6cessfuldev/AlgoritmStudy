package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2579 {
	
	static int[] arr;
	static int[] oneStep;
	static int[] twoStep;
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		oneStep = new int[n+1];
		twoStep = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		System.out.println(Math.max(one(n), two(n)));
		
	}

	public static int one(int n) {
		
		if(oneStep[n] == 0) {
			if(n == 1) {
				oneStep[n] = arr[1];
			}
			
			else if(n == 2) {
				
				oneStep[n] = arr[1]+arr[2];
			}
			
			else if(n == 3) {
				oneStep[n] = arr[2]+arr[3];
			}
			
			else if(n > 3) {
				//전 계단을 이용한 경우
				oneStep[n] = two(n-1) +arr[n];
			}
		}
		
		return oneStep[n];
	}
	
	public static int two(int n) {
		
		if(twoStep[n] == 0) {
			if(n == 1) {
				twoStep[n] = arr[1];
			}
			else if(n == 2) {
				twoStep[n] = arr[2];
			}
			else if(n == 3) {
				twoStep[n] = arr[1]+arr[3];
			}
			else if(n > 3) {
				twoStep[n] = Math.max(one(n-2), two(n-2))+arr[n];
			}
		}
		
		return twoStep[n];
		
	}
}


class Dp {
	int size;
	int[] arr;
	boolean[] visit;
	
	public Dp(int size) {
		arr = new int[size+1];
		visit = new boolean[size+1];
	}
	
	public void visit(int i, int value) {
		arr[i] = value;
		visit[i] = true;
	}
	
	public boolean visitable(int i) {
		if(i == 1 && i==2) return true;
		if(visit[i-1]&&visit[i-2]) return false;
		return true;
	}
	
	public boolean mustVisit(int i) {
		if(!visit[i-1]&& !visit[i-2]) return true;
		return false;
	}
	
	public int sum() {
		int sum = 0;
		for (int i : arr) {
			sum+=i;
		}
		return sum;
	}
}





