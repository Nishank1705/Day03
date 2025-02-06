public class ConcatenateStringsUsingStringBuffer {
    public static void main(String[] args) {
        String[] strings = {"hello", "world", "java", "rocks"};
        StringBuffer sb = new StringBuffer();

        for (String str : strings) {
            sb.append(str);
        }
        String concatenatedString = sb.toString();
        System.out.println("Concatenated string: " + concatenatedString);
    }
}
