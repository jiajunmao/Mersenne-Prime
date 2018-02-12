package main;

import java.math.BigInteger;

public class Tester {
	public static void main(String args[]) {
		isPrimeThread divt = new isPrimeThread(new BigInteger("2305843009213693951"));
		System.out.println(divt.call().toString());
	}
}
