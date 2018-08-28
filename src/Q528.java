import java.util.Arrays;
import java.util.Random;

public class Q528 {

    class Solution {

        int[] weight;
        int sum;
        Random random;

        public Solution(int[] w) {
            weight = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                weight[i] = sum;
            }
            random = new Random();
        }

        public int pickIndex() {
            int index = Arrays.binarySearch(weight, random.nextInt(sum));
            return index < 0 ? -index - 1 : index + 1;
        }
    }

}
