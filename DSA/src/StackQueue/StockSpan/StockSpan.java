package StackQueue.StockSpan;

import java.util.Stack;

public class StockSpan {
    
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements that are smaller or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Compute span
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index onto stack
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);

        System.out.println("Stock Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        System.out.println("\nStock Spans: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
