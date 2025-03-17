package searching_string.inputstream_reader.user_input;

import java.io.*;

public class UserInputToFile{
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Desktop\\BridgelabzDataStructure\\src\\searching_string\\info.txt";

        try (
            // Step 1: Read from console
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Step 2: Write to file
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            System.out.println("Enter text (type 'exit' to stop):");

            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                bufferedWriter.write(inputLine);
                bufferedWriter.newLine(); 
            }

            System.out.println("Input saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }
}
