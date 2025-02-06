package Day4;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInputToFile {
    public static void main(String[] args) {
        String outputPath = "N:/assignment/output.txt"; // Path to the output file

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(outputPath)) {

            String inputLine;
            System.out.println("finishing:");
            while (!(inputLine = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(inputLine + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

