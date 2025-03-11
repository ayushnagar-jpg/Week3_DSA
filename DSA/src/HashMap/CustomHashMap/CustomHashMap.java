package HashMap.CustomHashMap;

import java.util.LinkedList;

class CustomHashMap {
    private static final int SIZE = 1000;  // Size of the hash table
    private LinkedList<Entry>[] map;  // Array of linked lists

    // Entry class to store key-value pairs
    static class Entry {
        int key, value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the hash table
    @SuppressWarnings("unchecked")
	public CustomHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function to determine bucket index
    private int hash(int key) {
        return key % SIZE;
    }

    // Insert a key-value pair
    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Entry> bucket = map[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;  // Update value if key exists
                return;
            }
        }

        bucket.add(new Entry(key, value));  // Add new key-value pair
    }

    // Retrieve value for a key
    public int get(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = map[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value;  // Return value if key is found
            }
        }

        return -1;  // Key not found
    }

    // Remove a key-value pair
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = map[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                bucket.remove(entry);
                return;
            }
        }
    }

    // Display contents of the hash map
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (!map[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry entry : map[i]) {
                    System.out.print("[" + entry.key + " -> " + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap hashMap = new CustomHashMap();

        hashMap.put(1, 10);
        hashMap.put(2, 20);
        hashMap.put(1001, 30);  // Collides with key 1
        hashMap.put(3, 30);

        System.out.println("Value for key 2: " + hashMap.get(2));  // Output: 20
        System.out.println("Value for key 5: " + hashMap.get(5));  // Output: -1 (not found)

        hashMap.remove(2);
        System.out.println("Value for key 2 after removal: " + hashMap.get(2));  // Output: -1

        System.out.println("\nHashMap Contents:");
        hashMap.display();
    }
}
