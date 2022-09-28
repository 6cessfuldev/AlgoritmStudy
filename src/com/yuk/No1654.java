package com.yuk;

import java.util.Scanner;

public class No1654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		String[] strArr = str.split(" ");
		
		int[] intArr = new int[Integer.parseInt(strArr[0])];
		int sum = 0;
		for (int i = 0; i < Integer.parseInt(strArr[0]); i++) {
			intArr[i] = scan.nextInt();
			sum += intArr[i];
		}
		int avg = sum/Integer.parseInt(strArr[1]);
		
		while (true) {
			int cnt = 0;
			for (int i : intArr) {
				cnt += i/avg;
			}
			if(cnt >= Integer.parseInt(strArr[1])) {
				break;
			}
			avg--;
		}
		
		System.out.println(avg);
	}

}
