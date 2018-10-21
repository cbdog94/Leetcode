import java.util.Arrays;

public class Q927 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q927().threeEqualParts(new int[]{1, 0, 1, 0, 1})));
        System.out.println(Arrays.toString(new Q927().threeEqualParts(new int[]{1, 1, 0, 1, 1})));
    }

    public int[] threeEqualParts(int[] A) {
        StringBuilder sb = new StringBuilder();
        int[] next1 = new int[A.length];
        int next = -1;
        for (int a : A) {
            sb.append(a);
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                next = i;
            }
            next1[i] = next;
        }
        if (next1[0] == -1) {
            return new int[]{-1, -1};
        }

        for (int i = next1[0]; i <= A.length - 3; i++) {
            String s1 = sb.substring(next1[0], i + 1);
            int n = s1.length(), s2s = next1[i + 1];
            if (A.length - s2s >= 2 * n && s2s != -1) {
                String s2 = sb.substring(s2s, s2s + n);
                int s3s = next1[s2s + n];
                if (A.length - s3s == n && s3s != -1) {
                    String s3 = sb.substring(s3s, s3s + n);
                    if (s1.equals(s2) && s1.equals(s3)) {
                        return new int[]{i, s2s + n};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

}
