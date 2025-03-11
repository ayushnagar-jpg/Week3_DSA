package StackQueue.SlidingProblem;

import java.util.*;

public class SlidingWindowProblem {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements out of the current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // Remove all smaller elements as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add current index to the deque
            deque.offer(i);
            
            // Store the maximum for the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        int[] maxValues = maxSlidingWindow(nums, k);
        
        System.out.println("Sliding Window Maximums: " + Arrays.toString(maxValues));
    }
}

