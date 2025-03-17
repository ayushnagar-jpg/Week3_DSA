package searching_string.inputstream_reader.byte_stream;

import java.io.*;

public class ByteToCharStream {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Desktop\\BridgelabzDataStructure\\src\\searching_string\\info.txt";

        try (
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported charset used in the file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}

