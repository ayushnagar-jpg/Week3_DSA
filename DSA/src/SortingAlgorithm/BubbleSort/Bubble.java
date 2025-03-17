package SortingAlgorithm.BubbleSort;
import java.util.*;
public class Bubble {
	    // Method to implement Bubble Sort
	    public static void bubbleSort(int[] marks) {
	        int n = marks.length;
	        boolean swapped;
	        
	        for (int i = 0; i < n - 1; i++) {
	            swapped = false;
	            for (int j = 0; j < n - 1 - i; j++) {
	                if (marks[j] > marks[j + 1]) {
	                    // Swap elements if they are in the wrong order
	                    int temp = marks[j];
	                    marks[j] = marks[j + 1];
	                    marks[j + 1] = temp;
	                    swapped = true;
	                }
	            }
	            // If no two elements were swapped, array is already sorted
	            if (!swapped) break;
	        }
	    }

	    public static void main(String[] args) {
	        int[] studentMarks = {85, 92, 78, 88, 76, 95, 89};
	        
	        System.out.println("Original Marks: " + Arrays.toString(studentMarks));
	        bubbleSort(studentMarks);
	        System.out.println("Sorted Marks: " + Arrays.toString(studentMarks));
	    }
	}
