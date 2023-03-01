package ie.gmit.dip;

import java.util.Hashtable;

public class Results {
	public static void printResults() {
		int numRuns = 10;
		// different sized arrays to observe effects of size on efficiency
		int[] arraySizes = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };
		// create hashtables from results of sorting
		Hashtable<String, String> bubbleResults = new Hashtable<String, String>();
		Hashtable<String, String> insertionResults = new Hashtable<String, String>();
		Hashtable<String, String> selectionResults = new Hashtable<String, String>();
		Hashtable<String, String> heapResults = new Hashtable<String, String>();
		Hashtable<String, String> countResults = new Hashtable<String, String>();

		for (int i = 0; i < arraySizes.length; i++) {
			int currentArraySize = arraySizes[i];
			int[] testArray = Tester.randomArray(currentArraySize);

			double totalBubbleTime = Tester.testBubble(testArray, numRuns);
			double averageBubbleTime = Tester.getAverageTime(totalBubbleTime, numRuns);
			bubbleResults.put(String.format("%s", currentArraySize), String.format("%1$,.3f", averageBubbleTime));

			double totalInsertionTime = Tester.testInsert(testArray, numRuns);
			double averageInsertionTime = Tester.getAverageTime(totalInsertionTime, numRuns);
			// https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
			insertionResults.put(String.format("%s", currentArraySize), String.format("%1$,.3f", averageInsertionTime));

			double totalSelectionTime = Tester.testSelect(testArray, numRuns);
			double averageSelectionTime = Tester.getAverageTime(totalSelectionTime, numRuns);
			selectionResults.put(String.format("%s", currentArraySize), String.format("%1$,.3f", averageSelectionTime));

			double totalHeapTime = Tester.testHeap(testArray, numRuns);
			double averageHeapTime = Tester.getAverageTime(totalHeapTime, numRuns);
			heapResults.put(String.format("%s", currentArraySize), String.format("%1$,.3f", averageHeapTime));

			double totalCountTime = Tester.testCount(testArray, numRuns);
			double averageCountTime = Tester.getAverageTime(totalCountTime, numRuns);
			countResults.put(String.format("%s", currentArraySize), String.format("%1$,.3f", averageCountTime));
		}
		Tester.printTable();
		Tester.printTestResults("Bubble Sort", bubbleResults);
		Tester.printTestResults("Insertion Sort", insertionResults);
		Tester.printTestResults("Selection Sort", selectionResults);
		Tester.printTestResults("Heap Sort", heapResults);
		Tester.printTestResults("Counting Sort", countResults);

	}

}
