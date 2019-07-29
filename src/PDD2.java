import java.util.Scanner;

public class PDD2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        System.out.println(valid(input));
    }

    public static boolean valid(String[] input) {
        int[] map = new int[26];
        for (String s : input) {
            map[s.charAt(0) - 'A']++;
            map[s.charAt(s.length() - 1) - 'A']--;
        }
        for (int c : map) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
//CAT TIGER RPC
//CAT RPC