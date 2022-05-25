package ie.gmit.dip;

public class MergeSort extends ClassWrapper {
//	public static void main(String[] args) {
//
//		Random rand = new Random();
//		int[] numbers = new int[100];
//
//		for (int i = 0; i < numbers.length; i++) {
//			numbers[i] = rand.nextInt(1000);
//		}
//		System.out.println("Merge Sort, Before: ");
//		printArray(numbers);
//
//		mergeSort(numbers);
//
//		System.out.println("\nAfter: ");
//		printArray(numbers);
//
//	}

	// Merge Sort algorithm resources used from: Coding With John
	// https://www.youtube.com/watch?v=bOk35XmHPKs&t=415s
	// https://www.baeldung.com/java-merge-sort

	@Override
	int[] sortArrays(int[] arr) {
		return arr = mergeSort(arr, 0, arr.length - 1);
	}

	private static int[] mergeSort(int[] array, int lowIndex, int highIndex) {
		if (highIndex <= lowIndex)
			return array;

		int midIndex = (lowIndex + highIndex) / 2;

		// MergeSort the lower half of the array
		mergeSort(array, lowIndex, midIndex);

		// MergeSort the upper half of the array
		mergeSort(array, midIndex + 1, highIndex);

		// Repeat on both sides
		merge(array, lowIndex, midIndex, highIndex);

		return array;
	}

	private static void merge(int[] array, int lowIndex, int midIndex, int highIndex) {
		// The original Array gets broken into two parts, one left and right
		// Representing lower and higher indexes
		// Create temp arrays and use For Loops to insert our data to temp arrays
		int leftHalf[] = new int[midIndex - lowIndex + 1];
		int rightHalf[] = new int[highIndex - midIndex];

		for (int i = 0; i < leftHalf.length; i++)
			leftHalf[i] = array[lowIndex + i];
		for (int i = 0; i < rightHalf.length; i++)
			rightHalf[i] = array[midIndex + i + 1];

		int leftIndex = 0;
		int rightIndex = 0;

		// We compare the two arrays 
		// Copying from leftArray and rightArray back into array
		for (int i = lowIndex; i < highIndex + 1; i++) {
			if (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
				if (leftHalf[leftIndex] < rightHalf[rightIndex]) {
					array[i] = leftHalf[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightHalf[rightIndex];
					rightIndex++;
				}

			} else if (leftIndex < leftHalf.length) {

				array[i] = leftHalf[leftIndex];
				leftIndex++;

			} else if (rightIndex < rightHalf.length) {

				array[i] = rightHalf[rightIndex];
				rightIndex++;
			}
		}
	}

	@Override
	String getAlgo() {

		return "MergeSort:";
	}

//	private static void printArray(int[] numbers) {
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
//		}
//		
//	}
}
