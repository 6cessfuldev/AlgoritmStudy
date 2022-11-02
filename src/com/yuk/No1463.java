package com.yuk;

import java.util.Scanner;

public class No1463 {
	
	static int X;
	
	static Integer[] arr;

	static int count (int a) {
		
		if(arr[a] == null) {
			if(a%6==0) {
				arr[a] = Math.min(count(a/3), Math.min(count(a/2), count(a-1)))+1;
			} else if(a%3==0) {
				arr[a] = Math.min(count(a/3), count(a-1))+1;
			} else if(a%2==0) {
				arr[a] = Math.min(count(a/2), count(a-1))+1;
			} else {
				arr[a] = count(a-1)+1;
			}
		}
		return arr[a];
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		X = scan.nextInt();

		arr = new Integer[X+1];
		arr[0] = arr[1] = 0;
		System.out.println(count(X));
		
	}
}

