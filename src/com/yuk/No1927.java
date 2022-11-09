package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		MinHeap heap = new MinHeap(N);
		while(N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if(x>0) {
				heap.insert(x);
			} else {
				if(heap.back>1) {
					sb.append(heap.out()+"\n");					
				} else {
					sb.append(0+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}

class MinHeap{
	int[] arr;
	int back = 1;
	
	public MinHeap(int N) {
		arr = new int[N+1]; 
	}
	
	public void insert(int x) {
		int tmp = back;
		back++;
		while(tmp>1) {
			if(x<arr[tmp/2]) {
				arr[tmp]=arr[tmp/2];
				tmp=tmp/2;
			}else {
				break;
			}
		}
		arr[tmp] = x;
	}
	
	public int out() {
		//가장 뒤에 있는 값을 index 1로 옮긴 후 제자리 찾아가기
		int result = arr[1];
		back--;
		int tmp = 1;
		
		while(tmp*2<back) {
			int child = 0;
			
			//작은 자녀노드 구하기
			if(tmp*2+1<back) {
				child = (arr[tmp*2]< arr[tmp*2+1]) ? tmp*2 : tmp*2+1;
			} else {
				child = tmp*2;
			}
			
			//1번 인덱스로 옮긴 가장 뒤의 값과 자녀값과 비교하기
			if(arr[back]<arr[child]) {	
				break;
			}else {
				arr[tmp]=arr[child];
				tmp=child;
			}
		}
		arr[tmp] = arr[back];
		return result;
	}
}
