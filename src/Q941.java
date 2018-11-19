public class Q941 {
    public boolean validMountainArray(int[] A) {
        boolean firstHalf = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (!firstHalf) {
                    return false;
                }
            } else if (A[i] > A[i + 1]) {
                if (firstHalf) {
                    firstHalf = false;
                }
                if (i == 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return !firstHalf;
    }
}
