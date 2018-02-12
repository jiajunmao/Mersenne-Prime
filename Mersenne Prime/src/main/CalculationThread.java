package main;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class CalculationThread implements Runnable, MersenneBigInt {
	private ArrayList<BigInteger> numLst;
	private final static BigInteger CALCCOEFFICIENT = two;

	public CalculationThread() {
		numLst = new ArrayList<BigInteger>();
	}

	private void calculate() throws IOException {
		BigInteger count = one;
		while (true) {
			BigInteger countTemp = zero;
			BigInteger result = one;
			while (countTemp.compareTo(count) != 0) {
				result = result.multiply(CALCCOEFFICIENT);
				countTemp = countTemp.add(one);
			}
			result = result.subtract(one);
			numLst.add(result);
			count = count.add(one);
		}
	}

	@Override
	public void run(){
		try {
			calculate();
		} catch (IOException e) {
			System.out.println("Something is wrong with CalculationThread");
			e.printStackTrace();
		}

	}

	public BigInteger getQueueHeadAndRemove() {
		BigInteger resultInt = numLst.get(0);
		numLst.remove(0);
		return resultInt;
	}

	public BigInteger getQueueHead() {
		BigInteger resultInt = numLst.get(0);
		return resultInt;
	}

	public ArrayList<BigInteger> getQueue() {
		return numLst;
	}

	public boolean isQueueEmpty() {
		return numLst.isEmpty();
	}
}
