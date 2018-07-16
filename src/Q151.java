
public class Q151 {

    public static String reverseWords(String s) {
        String[] splits = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--) {
            sb.append(splits[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("   the   sky   is blue   "));
    }

}
