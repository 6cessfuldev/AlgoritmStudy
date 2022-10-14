package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2108 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		//산술평균
		int avg = (int)Math.round( (double)sum/N )  ; 
				
		//counting 정렬
		int[] counting = new int[8001];
		int[] result = new int[N];
		for (int i = 0; i < arr.length; i++) {
			//입력값에 4000을 더해서 카운팅 배열에 넣기(0~8000)
			counting[arr[i]+4000]++;
		}
		
		// 최빈값 구하기
		int freqMax = 0;
		int max = 0;
		for (int i = 0; i < counting.length; i++) {
			if (max < counting[i]) max = counting[i];
		}
		
		int cnt=0;
		
		for (int i = 0; i < counting.length; i++) {
			if(counting[i] == max) {
				System.out.println("최빈값"+ i);
				cnt++;
				freqMax = (i-4000);
			}
			if(cnt==2 && counting[i] ==max) {
				freqMax = (i-4000);
				break;
			}
		}
		for (int i = 1; i < counting.length; i++) {
			counting[i] += counting[i-1];
		}
		for (int i = arr.length-1; i >= 0; i--) {
			int value = arr[i]+4000;
			counting[value]--;
			result[counting[value]]=value-4000;
		}
		
		//중앙값
		int mid = result[N/2];
		
		//범위
		int range = result[N-1]-result[0];
		
		System.out.println(avg);
		System.out.println(mid);
		System.out.println(freqMax);
		System.out.println(range);
	}
}
