package StackQueue.CircularTour;

class CircularTour {
    // Function to find the first pump from where the journey can be completed
    public static int findStartingPump(int[] petrol, int[] distance) {
        int totalSurplus = 0, currentSurplus = 0, startIndex = 0;

        for (int i = 0; i < petrol.length; i++) {
            int balance = petrol[i] - distance[i];
            totalSurplus += balance;
            currentSurplus += balance;

            // If currentSurplus becomes negative, reset start index
            if (currentSurplus < 0) {
                startIndex = i + 1; // Move to the next pump
                currentSurplus = 0;
            }
        }
        
        // If totalSurplus is negative, no solution exists
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4}; // Petrol at each pump
        int[] distance = {6, 5, 3, 5}; // Distance to the next pump

        int start = findStartingPump(petrol, distance);
        if (start != -1) {
            System.out.println("Start at petrol pump index: " + start);
        } else {
            System.out.println("No solution exists");
        }
    }
}
