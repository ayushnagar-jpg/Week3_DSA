package SortingAlgorithm.HeapSort;
import java.util.Arrays;
public class Heap {

	    // Method to implement Heap Sort
	    public static void heapSort(int[] salaries) {
	        int n = salaries.length;
	        
	        // Build max heap
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(salaries, n, i);
	        }
	        
	        // Extract elements from heap one by one
	        for (int i = n - 1; i > 0; i--) {
	            // Swap root (largest element) with the last element
	            int temp = salaries[0];
	            salaries[0] = salaries[i];
	            salaries[i] = temp;
	            
	            // Call heapify on the reduced heap
	            heapify(salaries, i, 0);
	        }
	    }
	    
	    // Heapify function to maintain max heap property
	    public static void heapify(int[] salaries, int n, int i) {
	        int largest = i; // Initialize largest as root
	        int left = 2 * i + 1; // Left child
	        int right = 2 * i + 2; // Right child
	        
	        // Check if left child is larger than root
	        if (left < n && salaries[left] > salaries[largest]) {
	            largest = left;
	        }
	        
	        // Check if right child is larger than the largest so far
	        if (right < n && salaries[right] > salaries[largest]) {
	            largest = right;
	        }
	        
	        // If largest is not root, swap and continue heapifying
	        if (largest != i) {
	            int temp = salaries[i];
	            salaries[i] = salaries[largest];
	            salaries[largest] = temp;
	            
	            heapify(salaries, n, largest);
	        }
	    }

	    public static void main(String[] args) {
	        int[] salaryDemands = {55000, 70000, 60000, 85000, 50000, 75000};
	        
	        System.out.println("Original Salary Demands: " + Arrays.toString(salaryDemands));
	        heapSort(salaryDemands);
	        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaryDemands));
	    }
	}

