package SortingAlgorithm.InsertionSort;
import java.util.Arrays;
public class Insertion {

	
	    // Method to implement Insertion Sort
	    public static void insertionSort(int[] employeeIDs) {
	        int n = employeeIDs.length;
	        
	        for (int i = 1; i < n; i++) {
	            int key = employeeIDs[i];
	            int j = i - 1;
	            
	            // Move elements that are greater than key one position ahead
	            while (j >= 0 && employeeIDs[j] > key) {
	                employeeIDs[j + 1] = employeeIDs[j];
	                j--;
	            }
	            employeeIDs[j + 1] = key;
	        }
	    }

	    public static void main(String[] args) {
	        int[] employeeIDs = {1023, 1015, 1040, 1001, 1032, 1055};
	        
	        System.out.println("Original Employee IDs: " + Arrays.toString(employeeIDs));
	        insertionSort(employeeIDs);
	        System.out.println("Sorted Employee IDs: " + Arrays.toString(employeeIDs));
	    }
	}

	
