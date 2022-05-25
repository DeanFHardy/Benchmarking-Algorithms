package ie.gmit.dip;

import java.util.*;

public class RandArrayGenerator {
	
	final static Random rand = new Random();
	
	int[] randomArrayGenerate(int n) {
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(101);
		}
		
		return array;
	} 
	
}
