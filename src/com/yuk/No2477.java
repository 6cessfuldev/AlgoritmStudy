package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No2477 {
	
	//방향별로 더해서 전체 사각형의 넓이를 구한 뒤 
	//모서리에 왔을 때 방향이 반시계방향대로 돌지 않는 두 변을 지나치는 것을 포착해 작은 사각형의 두 변 구하기
	//4->2->3->1->4 순으로 방향이 바뀌지 않는 순간 직전 변의 길이와 바뀐 후 변의 길이를 구한다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Character> direction = new ArrayList<>();
		direction.add('4');
		direction.add('2');
		direction.add('3');
		direction.add('1');
		direction.add('4');
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		ArrayList<Integer> length = new ArrayList<>();
		ArrayList<Character> direct = new ArrayList<>();
		
		//가장 큰 사각형의 각 변 구하기
		//순서대로 방향, 길이를 각 리스트에 담기
		for (int i = 0; i < 6; i++) {
			String[] strArr = br.readLine().split(" ");
			char dir = strArr[0].charAt(0);
			int leng = Integer.parseInt(strArr[1]);
			direct.add(dir);
			length.add(leng);
			map.put(dir, map.getOrDefault(dir, 0)+leng);
		}
		
		int minx = 0;
		int miny = 0;
		boolean flag = false;
		for (int i = 0; i < direct.size()-1; i++) {
			if( direction.get(direction.indexOf(direct.get(i))+1) != direct.get(i+1) ){
				minx = length.get(i);
				miny = length.get(i+1);
				flag = true;
				break;
			}
		}
		if(!flag) {
			minx = length.get(length.size()-1);
			miny = length.get(0);
		}
		int bigOne = map.get('2')*map.get('3');
		int minOne = minx*miny; 

		System.out.println(N*(bigOne-minOne));
		
	}
}