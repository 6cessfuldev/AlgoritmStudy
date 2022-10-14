package com.yuk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No24060 {
	
	private static int[] a, tmp;
	private static int count = 0;
	private static int result = -1;
	private static int K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		a = new int[N];
		
		stk = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());  
		}
		tmp = new int[N];
		merge_sort(a, 0, a.length-1);
		
		System.out.println(result);
	}
	
	public static void merge_sort(int[] arr, int p, int r) {
		
		if(count > K) return;
		
		if(p<r) {
			int q  = (p+r)/2;
			merge_sort(arr, p, q);
			merge_sort(arr, q+1, r);
			merge(arr, p, q, r);
		}
		
	}
	
	public static void merge(int[] arr, int p, int q, int r) {
	
		int i = p;
		int j = q+1;
		int t = 0;
		while (i <= q && j <= r) {
			if(arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			}else {
				tmp[t++] = arr[j++];
			}
		}
		
		while(i <= q) {
			tmp[t++] = arr[i++];
		}
		while(j <= r) {
			tmp[t++] = arr[j++];
		}
		i = p;
		t= 0;
		while(i <= r) {
			count++;
			if(count == K) {
				result =tmp[t];
				break;
			}
			arr[i++] = tmp[t++];
		}
	}


	
}
