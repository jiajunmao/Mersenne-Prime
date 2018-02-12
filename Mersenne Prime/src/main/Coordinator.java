package main;

import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Coordinator {
	public void coordinator() throws IOException, InterruptedException, ExecutionException {
		//Define writers that will write an .txt for the result
		FileWrite writer = null;
		writer = new FileWrite();

		//Starting the calculation for 2^n-1 in an independent thread
		CalculationThread calc = new CalculationThread();
		Thread calcThread = new Thread(calc);
		calcThread.start();
		System.out.println("Calculation Thread Started");

		//Defining the execution and retrieval lists for DividerThread
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Future<BigInteger>> list = new LinkedList<Future<BigInteger>>();
		List<BigInteger> resultLst = new LinkedList<BigInteger>();

		//Dispense calculation task to individual thread
		//Fetch the 2^n-1 number from the calculation thread
		while (!calc.isQueueEmpty()) {
			Callable<BigInteger> divThread = new isPrimeThread(calc.getQueueHeadAndRemove());
			Future<BigInteger> future = executor.submit(divThread);
			list.add(future);
			System.out.println("Runnning thread number: " + list.size());

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).isDone()) {
					if (list.get(i).get() != null) {
						resultLst.add((BigInteger) list.get(i).get());
					}
					list.remove(i);
				}
			}
			for (int i = 0; i < resultLst.size(); i++) {
				writer.appendAndSpace(resultLst.get(i).toString());
			}
			writer.newLine();
			writer.newLine();
		}
	}
}
