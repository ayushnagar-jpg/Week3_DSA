package SortingAlgorithm.MergeSort;
import java.util.Arrays;
public class Merge {

	    // Method to implement Merge Sort
	    public static void mergeSort(int[] prices, int left, int right) {
	        if (left < right) {
	            int mid = left + (right - left) / 2;
	            
	            // Recursively sort first and second halves
	            mergeSort(prices, left, mid);
	            mergeSort(prices, mid + 1, right);
	            
	            // Merge the sorted halves
	            merge(prices, left, mid, right);
	        }
	    }
	    
	    // Merge two sorted subarrays
	    public static void merge(int[] prices, int left, int mid, int right) {
	        int n1 = mid - left + 1;
	        int n2 = right - mid;
	        
	        int[] leftArray = new int[n1];
	        int[] rightArray = new int[n2];
	        
	        // Copy data to temporary arrays
	        System.arraycopy(prices, left, leftArray, 0, n1);
	        System.arraycopy(prices, mid + 1, rightArray, 0, n2);
	        
	        int i = 0, j = 0, k = left;
	        
	        // Merge the temporary arrays back into the original
	        while (i < n1 && j < n2) {
	            if (leftArray[i] <= rightArray[j]) {
	                prices[k] = leftArray[i];
	                i++;
	            } else {
	                prices[k] = rightArray[j];
	                j++;
	            }
	            k++;
	        }
	        
	        // Copy remaining elements of leftArray
	        while (i < n1) {
	            prices[k] = leftArray[i];
	            i++;
	            k++;
	        }
	        
	        // Copy remaining elements of rightArray
	        while (j < n2) {
	            prices[k] = rightArray[j];
	            j++;
	            k++;
	        }
	    }
	    
	    public static void main(String[] args) {
	        int[] bookPrices = {450, 200, 150, 300, 500, 100};
	        
	        System.out.println("Original Book Prices: " + Arrays.toString(bookPrices));
	        mergeSort(bookPrices, 0, bookPrices.length - 1);
	        System.out.println("Sorted Book Prices: " + Arrays.toString(bookPrices));
	    }
	}


