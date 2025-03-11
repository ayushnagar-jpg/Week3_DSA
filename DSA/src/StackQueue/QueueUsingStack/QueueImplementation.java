package StackQueue.QueueUsingStack;

import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> stack1;  // For enqueue operation
    Stack<Integer> stack2;  // For dequeue operation

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: Push elements onto stack1
    public void enqueue(int data) {
        stack1.push(data);
    }

    // Dequeue operation: Remove element from the front of the queue
    public int dequeue() {
        // If stack2 is empty, move elements from stack1 to stack2
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek: Get the front element without removing it
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class QueueImplementation {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());  // 10
        System.out.println("Front: " + queue.peek());        // 20
        System.out.println("Dequeued: " + queue.dequeue());  // 20

        queue.enqueue(40);
        System.out.println("Dequeued: " + queue.dequeue());  // 30
        System.out.println("Dequeued: " + queue.dequeue());  // 40
        System.out.println("Queue Empty: " + queue.isEmpty()); // true
    }
}

