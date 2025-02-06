package Day4;

import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
    public static void main(String[] args) {
        String input = "hello";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        String result = sb.toString();
        System.out.println("String without duplicates: " + result);
    }
}

