package ie.gmit.dip;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;



public class Benchmarking {
	//Allows us to create new Arrays for Benchmark data
	private static final RandArrayGenerator RAND_ARRAY = new RandArrayGenerator();
	
	//Array Sizes used during testing
	private static final int[] ARRAY_SIZE = new int[] { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000, 12000, 15000, 20000, 50000 };


	
	protected void benchmarker(ClassWrapper sort) {
		double[] benchResults = new double[ARRAY_SIZE.length];
		//Get the name of specific Algorithm being benched and display name
		String algoName = sort.getAlgo(); 
		System.out.println(algoName);
		
		for(int i = 0; i < ARRAY_SIZE.length; i++) {
			double totalTime = 0d;
			
			//Loop to run test 10 times according to Project requirements 
			for (int average = 0; average < 10; average++) {
				int [] testArray = RAND_ARRAY.randomArrayGenerate(ARRAY_SIZE[i]);
				
				//The following code is taken from the CTA Project Guide
				long startTime = System.nanoTime();
				sort.sortArrays(testArray); //Abstract sortArrays method taken from ClassWrapper class to test
				long endTime = System.nanoTime();
				double timeElapsed = (endTime - startTime);
				double elapsedMillis = timeElapsed / 1000000.0;
				totalTime += elapsedMillis;
			}
			
			benchResults[i] = totalTime / 10;
			//Display your result output to the console 
			System.out.printf("\t%10.3f", benchResults[i]);
			
		}
		
		//Print graph results from Benchmarker method
		printResults(benchResults, algoName);
		System.out.println();
		
	}
	
	private void printResults(double[] results, String name) {
		double[] graphSize = new double[ARRAY_SIZE.length];
		for (int i =0; i < ARRAY_SIZE.length; i++) {
			graphSize[i] = ARRAY_SIZE[i];
		}
		//Following code is taken from the XChart Guide README 
		//XChart library downloaded from: https://knowm.org/open-source/xchart/
		//Example code can be found here: https://knowm.org/open-source/xchart/xchart-example-code/
		
		//Create Chart
		XYChart chart = QuickChart.getChart(name, "Array Size", "Running Time (Milliseconds)", "y(x)", graphSize, results);
		chart.getStyler().setXAxisMax((double) ARRAY_SIZE[ARRAY_SIZE.length - 1]);
		chart.getStyler().setXAxisMin((double) ARRAY_SIZE[0]);
		chart.getStyler().setYAxisMax(250.00d);
		chart.getStyler().setYAxisMin(0.00d);
		new SwingWrapper<XYChart>(chart).displayChart();
	}
	
	protected void displayInputSize() {
		System.out.println("Size" + "\t\t");
		for (int i = 0; i < ARRAY_SIZE.length; i++) {
			System.out.printf(("\t\t") + ARRAY_SIZE[i]);
		}
		System.out.println();
	}
		
}
