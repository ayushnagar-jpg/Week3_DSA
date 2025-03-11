package HashMap.PairCheckWithGivenSum;

import java.util.*;

class PairSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (seenNumbers.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }

            seenNumbers.add(num); // Store the current number
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        if (hasPairWithSum(arr, target)) {
            System.out.println("There exists a pair with the given sum.");
        } else {
            System.out.println("No pair found.");
        }
    }
}
