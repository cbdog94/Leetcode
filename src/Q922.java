import java.util.Arrays;

public class Q922 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q922().sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = (A.length - 1) % 2 == 0 ? A.length - 2 : A.length - 1;
        while (even < A.length && odd > 0) {
            if (A[even] % 2 != 0 && A[odd] % 2 == 0) {
                int t = A[even];
                A[even] = A[odd];
                A[odd] = t;
                even += 2;
                odd -= 2;
            } else {
                if (A[even] % 2 == 0) {
                    even += 2;
                }
                if (A[odd] % 2 != 0) {
                    odd -= 2;
                }
            }
        }
        return A;
    }

}
