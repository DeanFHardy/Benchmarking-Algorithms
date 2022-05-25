package ie.gmit.dip;

public class BubbleSort extends ClassWrapper {

//Redo of BubbleSort after introducing ClassWrapper class.
//Algorithm from Course Lecture on Sorting Algorithms used as resource: https://www.geeksforgeeks.org/bubble-sort/
	
	int[] sortArrays(int[] arr) {
		int outer, inner;
		boolean isSorted = true;
		// loop through the array to the arrays final index (length -1)
		for (outer = arr.length - 1; outer > 0; outer--) {
			for (inner = 0; inner < outer; inner++) {
				if (arr[inner] > arr[inner + 1])		
					swap(arr, inner, inner + 1);		
				isSorted = false;
			}
			if(isSorted) return arr;	
		}
		return arr;	
	}
	
	 private void swap(int[]arr ,int index1, int index2) {
		  int temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
	}
	 
	@Override
	String getAlgo() {
		
		return "BubbleSort: ";
		}

}
