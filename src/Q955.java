import java.util.Arrays;

public class Q955 {

    public static void main(String[] args) {
        System.out.println(new Q955().minDeletionSize(new String[]{"ca", "bb", "ac"}));
        System.out.println(new Q955().minDeletionSize(new String[]{"xc", "yb", "za"}));
        System.out.println(new Q955().minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
        System.out.println(new Q955().minDeletionSize(new String[]{"xga", "xfb", "yfa"}));
        System.out.println(new Q955().minDeletionSize(new String[]{"jsebodtwc", "cnneoytml", "eeneuyzlu", "ewpnmtivg"}));
    }

    public int minDeletionSize(String[] A) {
        int count = 0;
        int[] cmp = new int[A.length - 1];
        for (int i = 0, j; i < A[0].length(); i++) {
            boolean flag = true;
            int[] tmp = Arrays.copyOf(cmp, A.length - 1);
            for (j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    if (tmp[j] == 0) {
                        count++;
                        break;
                    }
                } else if (A[j].charAt(i) < A[j + 1].charAt(i)) {
                    tmp[j] = -1;
                }
                if (tmp[j] == 0) {
                    flag = false;
                }
            }
            if (j == A.length - 1) {
                if (flag) {
                    break;
                }
                cmp = tmp;
            }
        }
        return count;
    }

}
