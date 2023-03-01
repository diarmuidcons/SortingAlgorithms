package ie.gmit.dip;

import java.util.Hashtable;

public class Tester {
	// Generate a random array of numbers between 1 and 100 using math.random
	static int[] randomArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}

	// Calculate time taken to run sorting
	public static double testBubble(int[] a, int numRuns) {
		long startTime = System.nanoTime();
		for (int i = 0; i < numRuns; i++) {
			AlgorithmMethods.bubbleSort(a);
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		// Convert from nanoseconds to milliseconds
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	public static double testInsert(int[] a, int numRuns) {
		long startTime = System.nanoTime();
		for (int i = 0; i < numRuns; i++) {
			AlgorithmMethods.insertionSort(a);
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	public static double testSelect(int[] a, int numRuns) {
		long startTime = System.nanoTime();
		for (int i = 0; i < numRuns; i++) {
			AlgorithmMethods.selectionSort(a);
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	public static double testHeap(int[] a, int numRuns) {
		long startTime = System.nanoTime();
		for (int i = 0; i < numRuns; i++) {
			AlgorithmMethods.heapSort(a);
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	public static double testCount(int[] a, int numRuns) {
		long startTime = System.nanoTime();
		for (int i = 0; i < numRuns; i++) {
			AlgorithmMethods.countingSort(a);
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	// Get average time taken based on number of iterations
	public static double getAverageTime(double totalTime, int numRuns) {
		return totalTime / numRuns;
	}

	// formatting for results table
	public static void printTable() {
		System.out.format("%-20s%-9d%-9d%-9d%-9d%-9d%-9d%-9d%-9d%-9d%-9d%-9d%-9d%-9d\n", "Size", 100, 250, 500, 750,
				1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000);
	}

	// print results of benchmarking of different algorithms to fit the format of
	// the table heading
	public static void printTestResults(String method, Hashtable<String, String> values) {

		System.out.format("%-20s%-9s%-9s%-9s%-9s%-9s%-9s%-9s%-9s%-9s%-9s%-9s%-9s%-9s\n", method, values.get("100"),
				values.get("250"), values.get("500"), values.get("750"), values.get("1000"), values.get("1250"),
				values.get("2500"), values.get("3750"), values.get("5000"), values.get("6250"), values.get("7500"),
				values.get("8750"), values.get("10000"));
	}
}
