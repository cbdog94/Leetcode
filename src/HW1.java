import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(f(s));
    }

    public static String f(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        while (length > 0) {
            for (int i = '0'; i < count.length; i++) {
                if (count[i] != 0) {
                    sb.append((char) i);
                    count[i]--;
                    length--;
                }
            }
        }
        return sb.toString();
    }
}
