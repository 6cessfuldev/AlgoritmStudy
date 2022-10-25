package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No11866 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strArr = br.readLine().split(" ");
		
		int n = Integer.parseInt(strArr[0]);
		int k = Integer.parseInt(strArr[1]);
		Queue<Integer> queue = new LinkedList<>();
		int[] intArr = new int[n];
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		for (int i = 1; i <= n*k; i++) {
			if(i%k == 0) {
				intArr[i/k-1] = queue.poll();
			} else {
				queue.add(queue.poll());
			}
		}

		sb.append("<");
		for (int i = 0; i < intArr.length; i++) {
			sb.append(intArr[i]);
			if(i!=intArr.length-1) {
				sb.append(", ");
			}	else {
				sb.append(">");
			}
		}
		System.out.println(sb.toString());
	}
}
