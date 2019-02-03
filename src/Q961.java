import java.util.Random;

public class Q961 {
    /*public int repeatedNTimes(int[] A) {
        int[] count = new int[10000];
        for (int a : A) {
            count[a]++;
            if (count[a] == A.length / 2) {
                return a;
            }
        }
        return 0;
    }*/

    public int repeatedNTimes(int[] A) {
        Random random = new Random();
        int i, j;
        while (A[i = random.nextInt(A.length)] != A[j = random.nextInt(A.length)] || i == j) {

        }
        return A[i];
    }
}
