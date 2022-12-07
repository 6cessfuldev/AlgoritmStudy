package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No3053 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int r = Integer.parseInt(br.readLine());
		
		System.out.println(Math.round(r*r*Math.PI*1000000.0)/1000000.0);
		System.out.println(Math.round( 2.0*r*r*100000)/100000.0);
		
	}

}
