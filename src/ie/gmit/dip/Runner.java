package ie.gmit.dip;

public class Runner {
	
	//Will create and run our algorithm Objects
	//and allow them to be passed into our Benchmark method
	
	public static void main(String[] args) {
	
		
		
		Benchmarking bench = new Benchmarking();
		ClassWrapper bubbleAlgo = new BubbleSort();
		ClassWrapper quickAlgo = new QuickSort();
		ClassWrapper radixAlgo = new RadixSort();
		ClassWrapper insertAlgo = new InsertionSort();
		ClassWrapper mergeAlgo = new MergeSort();
		
		bench.displayInputSize();
		bench.benchmarker(bubbleAlgo);
		bench.benchmarker(quickAlgo);
		bench.benchmarker(radixAlgo);
		bench.benchmarker(insertAlgo);
		bench.benchmarker(mergeAlgo);
	}
	
	

}
