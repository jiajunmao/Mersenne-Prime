package main;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class isPrimeThread implements Callable<BigInteger>, MersenneBigInt {
	private BigInteger num;
	private boolean isPrime;

	public isPrimeThread(BigInteger num) {
		this.num = num;
		isPrime = true;
	}

	public BigInteger call() {
		System.out.println("Computing Number " + num);
		BigInteger count = two;

		while (count.compareTo(sqrt(num)) != 0) {
			if (num.remainder(count).equals(zero)) {
				isPrime = false;
				break;
			}
			count = count.add(one);
		}

		if (isPrime) {
			System.out.println("Prime found");
			return num;
		} else
			return null;
	}

	public BigInteger sqrt(BigInteger x) {
		BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
		BigInteger div2 = div;
		// Loop until we hit the same value twice in a row, or wind
		// up alternating.
		for (;;) {
			BigInteger y = div.add(x.divide(div)).shiftRight(1);
			if (y.equals(div) || y.equals(div2))
				return y;
			div2 = div;
			div = y;
		}
	}

	public LinkedList<BigInteger> genListUpToNum() {
		LinkedList<BigInteger> tempLst = new LinkedList<BigInteger>();
		BigInteger count = zero;

		while (count.compareTo(num) != 0) {
			tempLst.add(count);
			count = count.add(one);
		}
		return tempLst;
	}

}
