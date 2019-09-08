import java.util.Scanner;

public class Ali3_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(firstPosition(s));
    }

    private static int firstPosition(String s) {
        int[][] count = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'][0] == 0) {
                count[c - 'a'][1] = i;
            }
            count[c - 'a'][0]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i][0] == 1) {
                min = Math.min(min, count[i][1]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
