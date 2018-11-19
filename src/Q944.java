public class Q944 {

    public int minDeletionSize(String[] A) {
        if (A.length <= 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            if (!isSorted(A, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSorted(String[] A, int index) {
        int flag = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i].charAt(index) < A[i + 1].charAt(index)) {
                if (flag == 1) {
                    return false;
                }
                flag = -1;
            } else if (A[i].charAt(index) > A[i + 1].charAt(index)) {
                if (flag == -1) {
                    return false;
                }
                flag = 1;
            }
        }
        return true;
    }
}
