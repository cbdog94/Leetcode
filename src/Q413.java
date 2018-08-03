public class Q413 {

    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int last = A[1] - A[0], count = 2, result = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == last) {
                count++;
            } else {
                result += (count - 1) * (count - 2) / 2;
                last = A[i] - A[i - 1];
                count = 2;
            }
        }
        result += (count - 1) * (count - 2) / 2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 9, 8, 7, 6, 5}));
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 9, 8, 7, 6}));
        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7}));
    }

}
