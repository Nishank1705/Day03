package Day5;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReadingComparison {

    public static void main(String[] args) throws IOException {
        String filePath = "N:\\assignment\\example.txt"; 

        // Using FileReader
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                // Processing the data...
            }
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader: " + (endTime - startTime) / 1e6 + " ms");

        // Using InputStreamReader
        startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            int data;
            while ((data = inputStreamReader.read()) != -1) {
                // Processing the data...
            }
        }
        endTime = System.nanoTime();
        System.out.println("InputStreamReader: " + (endTime - startTime) / 1e6 + " ms");
    }
}

