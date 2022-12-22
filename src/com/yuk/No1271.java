package com.yuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;

public class No1271 {

	public static void main(String[] args) throws IOException {

		Scanner scan= new Scanner(System.in);
		BigInteger N = scan.nextBigInteger();
		BigInteger M = scan.nextBigInteger();
		
		BigInteger[] arr = N.divideAndRemainder(M);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}

}
