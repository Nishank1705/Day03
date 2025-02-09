package Day5;
public class StringConcatenationComparison {

    public static void main(String[] args) {
        int n = 1000000; // Number of concatenations

        // Using String
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a";
        }
        long endTime = System.nanoTime();
        System.out.println("String: " + (endTime - startTime) / 1e6 + " ms");

        // Using StringBuilder
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder: " + (endTime - startTime) / 1e6 + " ms");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer: " + (endTime - startTime) / 1e6 + " ms");
    }
}
