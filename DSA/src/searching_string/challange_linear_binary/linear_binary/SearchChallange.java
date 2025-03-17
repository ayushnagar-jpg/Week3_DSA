package searching_string.challange_linear_binary.linear_binary;

import java.util.Arrays;

public class SearchChallange{

    // --- Part 1: Linear Search for First Missing Positive ---
    public static int firstMissingPositive(int[] nums) {
    	int n = nums.length;

        for (int i = 1; i <= n + 1; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
        return -1;
    }

    // --- Part 2: Binary Search for Target Index ---
    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);  // Ensure array is sorted for binary search

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] inputArray = {3, 4, -1, 1};
        int target = 4;

        int missing = firstMissingPositive(Arrays.copyOf(inputArray, inputArray.length));
        System.out.println("First Missing Positive: " + missing);

        int index = binarySearch(Arrays.copyOf(inputArray, inputArray.length), target);
        System.out.println("Index of target (" + target + "): " + index);
    }
}

