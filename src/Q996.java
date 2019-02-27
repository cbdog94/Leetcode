import java.util.ArrayList;
import java.util.List;

public class Q996 {
    public static void main(String[] args) {
        System.out.println(new Q996().numSquarefulPerms(new int[]{1, 17, 8}));
        System.out.println(new Q996().numSquarefulPerms(new int[]{2, 2, 2}));
        System.out.println(new Q996().numSquarefulPerms(new int[]{1, 1, 1}));
    }

    public int numSquarefulPerms(int[] A) {
        return helper(new ArrayList<>(), A);
    }

    private int helper(List<Integer> tmp, int[] A) {
        if (tmp.size() == A.length) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if ((i == 0 || A[i] != A[i - 1]) && A[i] != -1) {
                if (tmp.size() == 0 || isPrefect(A[i] + tmp.get(tmp.size() - 1))) {
                    int t = A[i];
                    A[i] = -1;
                    tmp.add(t);
                    result += helper(tmp, A);
                    tmp.remove(tmp.size() - 1);
                    A[i] = t;
                }
            }
        }
        return result;
    }

    private boolean isPrefect(int n) {
        int m = (int) Math.floor(Math.sqrt(n) + 0.5);
        return m * m == n;
    }
}
