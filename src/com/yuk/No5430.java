package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Impl_No5430 {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	int pick ;
	
	public Impl_No5430(ArrayList<Integer> arr) {
		stack1.addAll(arr);
	}
	
	public void R () {
		if(pick%2 == 0) {
			int size = stack1.size();
			for (int i = 0; i < size; i++) {
				stack2.add(stack1.pop());
			}
		}else {
			int size = stack2.size();
			for (int i = 0; i < size; i++) {
				stack1.add(stack2.pop());
			}
		}
		pick++;
	}
	
	public void D (int n) {
		if(pick%2==0) {
			for (int i = 0; i < n; i++) {
				stack1.removeElementAt(0);							
			}
		}else {
			for (int i = 0; i < n; i++) {
				stack2.removeElementAt(0);				
			}
		}
	}
	
	public int size() {
		if(pick%2 == 0) {
			return stack1.size();
		}else {
			return stack2.size();
		}
	}
	
	public String toString() {
		if(pick%2==0) {
			return stack1.toString();
		} else {
			return stack2.toString();
		}
	}
	
}

public class No5430 {
	
	public static ArrayList<String> strArr(String p) {
		ArrayList<String> list = new ArrayList<>();
		int cnt = 1;
		for (int i = 1; i < p.length(); i++) {
			if(p.charAt(i) != p.charAt(i-1)) {
				list.add(String.valueOf( p.charAt(i-1))+cnt);
				cnt=1;
			}else {
				cnt++;
			}
			
			if(i==p.length()-1) {
				list.add(String.valueOf(p.charAt(i))+cnt);
			}
		}
		return list;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		loop1  :
		while(T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			StringTokenizer stk = new StringTokenizer(br.readLine(),"[],");
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(stk.nextToken()));
			}
			
			Impl_No5430 impl = new Impl_No5430(list);
			
			ArrayList<String> order = new ArrayList<>();
			
			for (int i = 0; i < order.size(); i++) {
				if(order.get(i).charAt(0)=='R') {
					if(Integer.parseInt(order.get(i).substring(1))%2==1){
						impl.R();
					}
				} else {
					int dCnt = Integer.parseInt(order.get(i).substring(1));
					impl.D(dCnt);
				}
			}
			
			sb.append(impl.toString()).append("\n");
			
		}

		System.out.println(sb);
	}

}
