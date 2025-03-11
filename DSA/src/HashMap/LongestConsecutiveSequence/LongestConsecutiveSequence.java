package HashMap.LongestConsecutiveSequence;

import java.util.HashSet;

class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num); // Store all elements in HashSet
        }

        int maxLength = 0;

        for (int num : nums) {
            // Only check for sequence if num is the start (num - 1 is not in the set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Check for consecutive elements
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                maxLength = Math.max(maxLength, currentStreak);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums));
    }
}
