package StackQueue.StackRecursion;

import java.util.Stack;

public class SortStack {

    // Function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Remove the top element
            int top = stack.pop();

            // Step 2: Recursively sort the remaining stack
            sortStack(stack);

            // Step 3: Insert the popped element at the correct position
            insertSorted(stack, top);
        }
    }

    // Helper function to insert an element at its correct position
    private static void insertSorted(Stack<Integer> stack, int element) {
        // If stack is empty or element is greater than the top, push it
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            // Step 1: Remove the top element
            int top = stack.pop();

            // Step 2: Recursively find the correct position
            insertSorted(stack, element);

            // Step 3: Push the popped element back
            stack.push(top);
        }
    }

    // Driver code to test the sorting function
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        
        // Sort the stack
        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

