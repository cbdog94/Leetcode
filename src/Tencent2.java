import java.util.Arrays;
import java.util.Scanner;

public class Tencent2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt(), L = scanner.nextInt();
        int[][] clips = new int[s][2];
        for (int i = 0; i < s; i++) {
            clips[i][0] = scanner.nextInt();
            clips[i][1] = scanner.nextInt();
        }
        System.out.println(cover(clips, L));
    }

    private static int cover(int[][] clips, int L) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        if (clips[0][0] > 0) {
            return -1;
        }
        int last = 0, max = -1, count = 1;
        for (int[] clip : clips) {
            if (clip[0] > last) {
                if (last == max) {
                    return -1;
                }
                last = max;
                if (last >= L) {
                    return count;
                }
                count++;
            }
            max = Math.max(max, clip[1]);

        }
        return max >= L ? count : -1;
    }

}
