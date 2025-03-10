package LinkedList.RoundRobinSchedulingAlgorithm;

import java.util.Scanner;

class Process {
    int processId, burstTime, remainingTime;
    Process next;

    public Process(int processId, int burstTime) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add a new process at the end
    public void addProcess(int processId, int burstTime) {
        Process newProcess = new Process(processId, burstTime);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular Link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular nature
        }
    }

    // Remove a process after execution
    private void removeProcess(Process prev, Process current) {
        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            tail.next = head;
        } else if (current == tail) {
            prev.next = head;
            tail = prev;
        } else {
            prev.next = current.next;
        }
    }

    // Execute Round Robin Scheduling
    public void executeScheduling() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }
        
        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;

        Process current = head;
        Process prev = tail;

        while (head != null) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= executionTime;
                currentTime += executionTime;
                
                if (current.remainingTime == 0) {
                    int turnaroundTime = currentTime;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalTurnaroundTime += turnaroundTime;
                    totalWaitingTime += waitingTime;
                    processCount++;
                    System.out.println("Process " + current.processId + " completed. Turnaround Time: " + turnaroundTime + ", Waiting Time: " + waitingTime);
                    removeProcess(prev, current);
                    current = prev.next;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }
        
        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / processCount);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processCount);
    }
}

public class RoundRobinDemo {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time quantum: ");
        int timeQuantum = scanner.nextInt();
        
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);
        
        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.addProcess(3, 8);
        
        System.out.println("Executing Round Robin Scheduling:");
        scheduler.executeScheduling();
    }
}

