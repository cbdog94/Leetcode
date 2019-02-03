import java.util.Arrays;

public class Q982 {

    public static void main(String[] args) {
        System.out.println(new Q982().countTriplets(new int[]{2, 1, 3}));
    }

    public int countTriplets(int[] A) {
        int result = 0;
        int[] map = new int[1 << 16];
        Arrays.fill(map, -1);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int x = A[i] & A[j];
                if (map[x] == -1) {
                    map[x] = 0;
                    for (int k = 0; k < A.length; k++) {
                        if ((x & A[k]) == 0) {
                            map[x]++;
                        }
                    }
                }
                result += map[x];
            }
        }
        return result;
    }
}
