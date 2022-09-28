package com.yuk;

import java.util.ArrayList;
import java.util.Scanner;

public class No1436 {

	public static void main(String[] args) {
		/* 666
		 * 1666 2666 3666 4666 5666 
		 * 6661 6662 6663 6664 6665 6666 6667 6668 6669 
		 * 7666 8666 9666
		 */
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int cnt = 0;
		
		int sixx = 666;
		
		while (true) {

			String str = String.valueOf(sixx);
			for(int i=0; i<str.length()-2; i++) {
				if(str.charAt(i)=='6' && str.charAt(i)==str.charAt(i+1) && str.charAt(i)==str.charAt(i+2)) {
				cnt++; break;
				}
			}
			if(cnt == N) {
				break;
			}
			sixx++;
		}
		System.out.println(sixx);
	}

}
