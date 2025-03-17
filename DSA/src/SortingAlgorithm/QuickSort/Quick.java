package SortingAlgorithm.QuickSort;
import java.util.Arrays;
public class Quick {
	
	    // Method to implement Quick Sort
	    public static void quickSort(int[] prices, int low, int high) {
	        if (low < high) {
	            // Partition the array and get the pivot index
	            int pivotIndex = partition(prices, low, high);
	            
	            // Recursively sort the left and right subarrays
	            quickSort(prices, low, pivotIndex - 1);
	            quickSort(prices, pivotIndex + 1, high);
	        }
	    }

	    // Partition method to rearrange elements based on pivot
	    public static int partition(int[] prices, int low, int high) {
	        int pivot = prices[high]; // Choosing the last element as pivot
	        int i = low - 1;
	        
	        for (int j = low; j < high; j++) {
	            if (prices[j] < pivot) {
	                i++;
	                // Swap prices[i] and prices[j]
	                int temp = prices[i];
	                prices[i] = prices[j];
	                prices[j] = temp;
	            }
	        }
	        
	        // Swap pivot element with element at i+1
	        int temp = prices[i + 1];
	        prices[i + 1] = prices[high];
	        prices[high] = temp;
	        
	        return i + 1;
	    }

	    public static void main(String[] args) {
	        int[] productPrices = {1200, 450, 300, 800, 1500, 600};
	        
	        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));
	        quickSort(productPrices, 0, productPrices.length - 1);
	        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
	    }
	}



