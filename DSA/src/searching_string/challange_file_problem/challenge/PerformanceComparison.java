package searching_string.challange_file_problem.challenge;

import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== StringBuilder vs StringBuffer ===");
        compareStringBuilders();

        System.out.println("\n=== FileReader vs InputStreamReader ===");
        String filePath = "C:\\Users\\DELL\\Desktop\\BridgelabzDataStructure\\src\\searching_string\\info.txt"; // Replace with actual large file path
        compareFileReaders(filePath);
    }

    // Part 1: StringBuilder vs StringBuffer
    public static void compareStringBuilders() {
        int iterations = 1_000_000;
        String word = "hello";

        // StringBuilder
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(word);
        }
        long endSB = System.nanoTime();
        System.out.println("StringBuilder time: " + (endSB - startSB) / 1_000_000 + " ms");

        // StringBuffer
        long startSBF = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(word);
        }
        long endSBF = System.nanoTime();
        System.out.println("StringBuffer time: " + (endSBF - startSBF) / 1_000_000 + " ms");
    }

    // Part 2: FileReader vs InputStreamReader (word count)
    public static void compareFileReaders(String filePath) {
        // Using FileReader
        try (
            BufferedReader br = new BufferedReader(new FileReader(filePath))
        ) {
            long start = System.nanoTime();
            int wordCount = countWords(br);
            long end = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("FileReader Error:");
            e.printStackTrace();
        }

        // Using InputStreamReader
        try (
            BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8")
            )
        ) {
            long start = System.nanoTime();
            int wordCount = countWords(br);
            long end = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time: " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("InputStreamReader Error:");
            e.printStackTrace();
        }
    }

    // Utility to count words
    public static int countWords(BufferedReader reader) throws IOException {
        String line;
        int wordCount = 0;
        while ((line = reader.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            if (!line.trim().isEmpty()) {
                wordCount += words.length;
            }
        }
        return wordCount;
    }
}
