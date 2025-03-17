package SortingAlgorithm.CountingSort;
import java.util.Arrays;
public class Counting {
	
	    // Method to implement Counting Sort
	    public static void countingSort(int[] ages, int minAge, int maxAge) {
	        int range = maxAge - minAge + 1;
	        int[] count = new int[range];
	        int[] output = new int[ages.length];

	        // Count occurrences of each age
	        for (int age : ages) {
	            count[age - minAge]++;
	        }

	        // Compute cumulative frequencies
	        for (int i = 1; i < count.length; i++) {
	            count[i] += count[i - 1];
	        }

	        // Place elements in correct position in output array
	        for (int i = ages.length - 1; i >= 0; i--) {
	            output[count[ages[i] - minAge] - 1] = ages[i];
	            count[ages[i] - minAge]--;
	        }

	        // Copy sorted output array back to original array
	        System.arraycopy(output, 0, ages, 0, ages.length);
	    }

	    public static void main(String[] args) {
	        int[] studentAges = {12, 15, 11, 18, 14, 13, 16, 12, 14, 17};
	        
	        System.out.println("Original Student Ages: " + Arrays.toString(studentAges));
	        countingSort(studentAges, 10, 18);
	        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
	    }
	}


