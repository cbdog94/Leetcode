import java.util.Arrays;
import java.util.Random;

public class Q497 {
    public static void main(String[] args) {
        Solution s = new Q497().new Solution(new int[][]{{82918473, -57180867, 82918476, -57180863}, {83793579, 18088559, 83793580, 18088560}, {66574245, 26243152, 66574246, 26243153}, {72983930, 11921716, 72983934, 11921720}});
        for (int i = 0; i < 100; i++)
            System.out.println(Arrays.toString(s.pick()));
    }

    class Solution {

        int[] width;
        Random random;
        int sum;
        int[][] rects;

        public Solution(int[][] rects) {
            width = new int[rects.length];
            int index = 0;
            for (int[] rect : rects) {
                sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                width[index++] = sum;
            }
            random = new Random();
            this.rects = rects;
//            System.out.println(sum);
        }

        public int[] pick() {
            int ran = random.nextInt(sum + 1);
            int index = Arrays.binarySearch(width, ran);
            if (index < 0) {
                index = -index - 1;
            } else {
                index++;
            }
            ran -= (index == 0 ? 0 : width[index - 1]);
            int x = rects[index][0] + ran % (rects[index][2] - rects[index][0] + 1);
            int y = rects[index][1] + ran / (rects[index][2] - rects[index][0] + 1);
            return new int[]{x, y};
        }
    }
}