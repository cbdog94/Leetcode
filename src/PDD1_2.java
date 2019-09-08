import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PDD1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String left = sc.next(), right = sc.next();
            check(left, right);
        }
    }

    private static void check(String left, String right) {
        int[] mapL = new int[10], mapR = new int[10];
        for (char c : left.toCharArray()) {
            mapL[c - '0']++;
        }
        for (char c : right.toCharArray()) {
            mapR[c - '0']++;
        }
        for (int i = 1; i <= 9; i++) {
            if (mapL[i] < mapR[i]) {
                System.out.println("{");
                System.out.println("}");
                return;
            }
        }
        List<String> result = new ArrayList<>();
        backtrack(result, 0, left, right, "", "");
        System.out.println("{");
        for (String s : result) {
            System.out.println(s.trim());
        }
        System.out.println("}");
    }

    private static void backtrack(List<String> result, int s, String left, String right, String tmp, String tmpResult) {
        if (s == left.length()) {
            if (tmp.equals(right)) {
                result.add(tmpResult);
            }
            return;
        }
        backtrack(result, s + 1, left, right, tmp, tmpResult + "d ");
        backtrack(result, s + 1, left, right, left.charAt(s) + tmp, tmpResult + "l ");
        backtrack(result, s + 1, left, right, tmp + left.charAt(s), tmpResult + "r ");
    }

}
