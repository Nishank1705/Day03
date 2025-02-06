package Day4;
public class SearchSpecificWord {
    public static void main(String[] args) {
        String[] sentences = {
            "This is the first sentence.",
            "This is the second sentence.",
            "This sentence contains the word."
        };
        String targetWord = "contains";
        String result = findSentenceWithWord(sentences, targetWord);
        System.out.println("Sentence with the target word: " + result);
    }

    private static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}

