import java.util.Arrays;

public class Q762 {

    public int countPrimeSetBits(int L, int R) {
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int result = 0;
        for (int i = L; i <= R; i++) {
            if (Arrays.binarySearch(prime, Integer.bitCount(i)) >= 0) {
                result++;
            }
        }
        return result;
    }
}
