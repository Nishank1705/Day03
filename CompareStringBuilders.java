import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class CompareStringBuilders {
    public static void main(String[] args) throws Exception {
        // Part 1: StringBuilder vs StringBuffer

        String str = "hello";
        int times = 1_000_000;

        // StringBuilder
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + "ms");

        // StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sbf.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + "ms");

        // Part 2 for FileReader vs InputStreamReader

        // File path for the large text file (100MB)
        String filePath = "N:\\assignment\\example.txt";

        // FileReader
        startTime = System.currentTimeMillis();
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        int wordCountFileReader = countWords(fileReader);
        endTime = System.currentTimeMillis();
        System.out.println("Word count using FileReader: " + wordCountFileReader);
        System.out.println("Time taken by FileReader: " + (endTime - startTime) + "ms");

        // InputStreamReader
        startTime = System.currentTimeMillis();
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        int wordCountInputStreamReader = countWords(inputStreamReader);
        endTime = System.currentTimeMillis();
        System.out.println("Word count using InputStreamReader: " + wordCountInputStreamReader);
        System.out.println("Time taken by InputStreamReader: " + (endTime - startTime) + "ms");
    }

    // Method to count words in a BufferedReader
    private static int countWords(BufferedReader reader) throws Exception {
        int wordCount = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            wordCount += tokenizer.countTokens();
        }
        reader.close();
        return wordCount;
    }
}

