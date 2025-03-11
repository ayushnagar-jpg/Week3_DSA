package HashMap.SubArrayWithZeroSum;

import java.util.*;

class ZeroSumSubarrays {
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>(); // Stores sum and indices
        List<List<Integer>> result = new ArrayList<>();
        
        int cumulativeSum = 0;
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1))); // Handle sum = 0 at start

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // If cumulativeSum has appeared before, subarrays exist
            if (sumMap.containsKey(cumulativeSum)) {
                for (int start : sumMap.get(cumulativeSum)) {
                    result.add(Arrays.asList(start + 1, i)); // Store (start+1, end) indices
                }
            }

            // Add current index to sumMap
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, 2}; // Test case
        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);

        if (subarrays.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
        } else {
            System.out.println("Zero-sum subarrays (start, end): " + subarrays);
        }
    }
}
