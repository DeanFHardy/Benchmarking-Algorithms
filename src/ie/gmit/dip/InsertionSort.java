package ie.gmit.dip;

public class InsertionSort extends ClassWrapper {

//	public static void main(String[] args) {
//
//		Random rand = new Random();
//		int[] numbers = new int[10];
//
//		for (int i = 0; i < numbers.length; i++) {
//			numbers[i] = rand.nextInt(100);
//		}
//		System.out.println(" Insertion Sort, Before: ");
//		printArray(numbers);
//
//		insertionSort(numbers);
//
//		System.out.println("\nAfter: ");
//		printArray(numbers);
//
//	}
	
	//Insertion Sort resource used: https://www.youtube.com/results?search_query=insertion+sort+java

	@Override
	int[] sortArrays(int[] arr) {
		return arr = insertionSort(arr);
	}

	// Insertion Sort:
	private static int[] insertionSort(int[] inputArray) {
		//Start from the second position of the array
		for (int i = 1; i < inputArray.length; i++) {
			// Create a temporary value from the current Value of Input Array
			int currentValue = inputArray[i];

			// Walk back through the Loop
			int j = i - 1;
			while (j >= 0 && inputArray[j] > currentValue) {
				inputArray[j + 1] = inputArray[j];
				// Decrement j so we can check current value to the next lower value
				j--;
			}
			inputArray[j + 1] = currentValue;

		}
		return inputArray;
	}

	@Override
	String getAlgo() {
		return "InsertionSort: ";
	}

//	private static void printArray(int[] numbers) {
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
//		}
//	}

}
