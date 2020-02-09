import java.util.Scanner;

public class MHY1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] map = new int[101];
        int min = 101, max = -1, zero = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t == 0) {
                zero++;
            } else {
                map[t]++;
                if (map[t] > 1) {
                    flag = false;
                }
                min = Math.min(min, t);
                max = Math.max(max, t);
            }
        }
        if (!flag) {
            System.out.println("NO+" + zero);
            return;
        }
        int empty = 0;
        for (int i = min; i <= max; i++) {
            if (map[i] == 0) {
                empty++;
            }
        }
        if (empty <= zero) {
            System.out.println("YES+" + zero);
        } else {
            System.out.println("NO+" + zero);
        }
    }
}
