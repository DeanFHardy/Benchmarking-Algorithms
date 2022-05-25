package ie.gmit.dip;

import java.util.Random;

public class QuickSort extends ClassWrapper {

//	public static void main(String[] args) {
//		Random rand = new Random();
//		int[] numbers = new int[10];
//		
//		for (int i = 0; i < numbers.length; i++) {
//			numbers[i] = rand.nextInt(100);
//		}
//		
//		System.out.println(" Quicksort, Before:");
//		printArray(numbers);
//		
//		quicksort(numbers);
//		
//		System.out.println("\nAfter: ");
//		printArray(numbers);
//			
//	}
	
	//Algorithm resources include: Coding with John & GeeksforGeeks
	//https://www.youtube.com/watch?v=h8eyY7dIiN4
	//https://www.geeksforgeeks.org/quick-sort/

	@Override
	int[] sortArrays(int[] arr) {
		return arr = quickSort(arr, 0, arr.length - 1);
	}// end sort

	private int[] quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pointer = partioning(array, low, high);

			// Seperate and sort left and right partions
			quickSort(array, low, pointer - 1);
			quickSort(array, pointer + 1, high);
		}
		return array;
	}

	private int partioning(int[] arr, int low, int high) {
		swapIndex(arr, low, getPivot(low, high));
		int border = low + 1;
		for (int i = border; i <= high; i++) {
			if (arr[i] < arr[low]) {
				swapIndex(arr, i, border++);
			}
		}
		swapIndex(arr, low, border - 1);
		return border - 1;
	}

	//Randomising the Pivot number results in a quicker algorithm
	private int getPivot(int low, int high) {
		Random rand = new Random();
		return rand.nextInt((high - low) + 1) + low;
	}

	// Swap method
	private static void swapIndex(int[] array, int num1, int num2) {
		int temp = array[num1];
		array[num1] = array[num2];
		array[num2] = temp;
	}

//	private static void printArray(int[] numbers) {
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
//		}
//
//	}

	@Override
	String getAlgo() {
		// TODO Auto-generated method stub
		return "QuickSort: ";
	}

}
