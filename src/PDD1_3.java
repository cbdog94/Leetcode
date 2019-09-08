import java.util.Scanner;

public class PDD1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        k = n * m - k + 1;
        int lo = 1, hi = n * m + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = m;
            for (int i = 1; i <= n; i++) {
                while (j >= 1 && i * j > mid) j--;
                count += j;
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }

        System.out.println(lo);
    }

}
