import java.util.ArrayList;
import java.util.List;

public class Q969 {
    public static void main(String[] args) {
        System.out.println(new Q969().pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(new Q969().pancakeSort(new int[]{1, 2, 3}));
    }

    public List<Integer> pancakeSort(int[] A) {
        return pancakeSort(A, A.length);
    }

    private List<Integer> pancakeSort(int[] A, int n) {
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (A[i] < A[i - 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return new ArrayList<>();
        }
        int max = -1, maxi = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                maxi = i;
                max = A[i];
            }
        }
        for (int i = 0; i <= maxi / 2; i++) {
            int t = A[i];
            A[i] = A[maxi - i];
            A[maxi - i] = t;
        }
        for (int i = 0; i < n / 2; i++) {
            int t = A[i];
            A[i] = A[n - i - 1];
            A[n - i - 1] = t;
        }
//        System.out.println(Arrays.toString(A));
//        List<Integer> rest = pancakeSort(A, n - 1);
        List<Integer> result = new ArrayList<>();
        if (maxi != 0) {
            result.add(maxi + 1);
        }
        result.add(n);
        result.addAll(pancakeSort(A, n - 1));
        return result;
    }
}
