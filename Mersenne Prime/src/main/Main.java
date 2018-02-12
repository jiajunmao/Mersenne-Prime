package main;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
	public static void main(String args[]) {
		Coordinator calc = new Coordinator();
		try {
			calc.coordinator();
		} catch (IOException | InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
