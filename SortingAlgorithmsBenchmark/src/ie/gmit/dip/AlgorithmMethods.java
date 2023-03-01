package ie.gmit.dip;

public class AlgorithmMethods {

	// Bubble Sort
	// https://web.microsoftstream.com/video/88aa6c0b-26c4-4be1-b132-e1ca5225e53c
	public static void bubbleSort(int[] arr) {
		int outer, inner;
		// Decrement the value of outer every time
		for (outer = arr.length - 1; outer > 0; outer--) {
			// Increments the value of inn every time
			for (inner = 0; inner < outer; inner++) {
				// Finds if elements are out of order
				if (arr[inner] > arr[inner + 1]) {
					// Swaps out of order elements
					int temp = arr[inner];
					arr[inner] = arr[inner + 1];
					arr[inner + 1] = temp;
				}
			}
		}

	}

	// Insertion Sort
	// https://web.microsoftstream.com/video/88aa6c0b-26c4-4be1-b132-e1ca5225e53c
	public static void insertionSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			// Key is the value of the loop counter
			int key = arr[i];
			// Index used to check all elements to the left of the key
			int j = i - 1;
			// Move any elements bigger than the key right by one position
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			// Put key in its new position
			arr[j + 1] = key;
		}
	}

	// Selection Sort
	// https://www.geeksforgeeks.org/selection-sort/
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			// find smallest element in unsorted array
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min])
					min = j;
				// swap smallest element found with first element in array
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}

	// Heap Sort
	// https://www.geeksforgeeks.org/heap-sort/?ref=lbp
	public static void heapSort(int arr[]) {
		int n = arr.length;

		// Rearrange array
		for (int i = n / 2 - 1; i >= 0; i--) {
			// Creates a max heap
			heapify(arr, n, i);
		}
		// Extract elements from heap
		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Call max heapify on reduced heap
			heapify(arr, i, 0);
		}
	}

	// Creates a heap data structure from a binary tree
	static void heapify(int[] arr, int n, int i) {
		// Make largest the root
		int biggest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		// If left child is bigger than the root
		if (l < n && arr[l] > arr[biggest]) {
			biggest = l;
		}
		// If right child is bigger than the biggest so far
		if (r < n && arr[r] > arr[biggest]) {
			biggest = r;
		}
		// if the root is not the biggest
		if (biggest != i) {
			int swap = arr[i];
			arr[i] = arr[biggest];
			arr[biggest] = swap;

			heapify(arr, n, biggest);
		}
	}

	// Counting Sort
	// https://www.javainuse.com/java/countingsort
	// This also accommodates for multiple occurrences of the same element in an
	// array
	public static void countingSort(int arr[]) {
		int arrayLength = arr.length;
		if (arrayLength == 0)
			return;
		// Get max and min values
		int max = arr[0], min = arr[0];
		for (int i = 1; i < arrayLength; i++) {
			if (arr[i] > max) {
				max = arr[i];
				if (arr[i] < min)
					min = arr[i];
			}
		}
		int range = max - min + 1;

		int[] count = new int[range];

		// Initialize the array
		for (int i = 0; i < arrayLength; i++) {
			count[arr[i]]++;
		}
		// Find how many indeces are present in array
		for (int i = 1; i < range; i++) {
			count[i] += count[i - 1];
		}

		// Arrange elements in the array, also taking in the number of occurrences of
		// the element
		int j = 0;
		for (int i = 0; i < range; i++) {
			while (j < count[i])
				arr[j++] = i + min;
		}
	}
}
