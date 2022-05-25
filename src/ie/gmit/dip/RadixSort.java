package ie.gmit.dip;

import java.util.Arrays;

public class RadixSort extends ClassWrapper {
	
	//Radix Sort algorithm used from: 
	//https://www.youtube.com/watch?v=4ungd6NXFYI
	
	@Override
	int[] sortArrays(int[] arr) {
		return arr = radixSort(arr, arr.length);
	}

	
	private static int getMaxValue(int array[], int n) {
		int max = array[0];
		for (int i = 1; i < n; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	
	//This method is used to find the max value in the array
	private static int[] radixSort(int array[], int n) {
		int maxValue = getMaxValue(array, n);
		
		//Counting sort for each individual digit throughout the array
		for (int exp = 1; maxValue / exp > 0; exp *= 10)
			countSort(array, n, exp);
		
		return array;
		
	}
	
	private static void countSort(int array[], int n, int exp) {
		int output[] = new int[n];	
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		for (i = 0; i < n; i++) count[(array[i] / exp) % 10]++;
		
		for (i = 1; i < 10; i++) count[i] += count[i -1];
		
		for (i = n - 1; i >=0; i--) {
			output[count[(array[i] / exp) % 10] - 1] = array[i];
			count[(array[i] / exp) % 10] --;
		}
		
		for(i = 0; i < n; i++) array[i] = output[i];
		
	}
	
	private static void print(int array[], int n) {
		for (int i = 0; i < n; i++)
			System.out.println(array[i] + "");
	}
	
	public static void main(String[] args) {
		int array[] = {170, 345, 785, 672, 111, 4, 29};
		int n = array.length;
		
		radixSort(array, n);
		print(array, n);
				
	}

	@Override
	String getAlgo() {
		// TODO Auto-generated method stub
		return "RadixSort: ";
	}

}
