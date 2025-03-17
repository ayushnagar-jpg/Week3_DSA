package searching_string.file_reader.file_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {

    public static void main(String[] args) {
        // Fixed file path (escaped backslashes)
        String filePath = "C:\\Users\\DELL\\Desktop\\BridgelabzDataStructure\\src\\searching_string\\info.txt";
        
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Changed to println for line-by-line output
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}
