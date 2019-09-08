import java.util.Scanner;

public class Unity2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(consists(a, b));
    }

    private static String consists(String a, String b) {
        int[] mapA = new int[26], mapB = new int[26];
        for (char c : a.toCharArray()) {
            mapA[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            mapB[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (mapA[i] > mapB[i]) {
                return "NO";
            }
        }
        return "YES";
    }
}
