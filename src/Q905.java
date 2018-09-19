import java.util.Arrays;

public class Q905 {

    public static int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            while (A[left] % 2 == 0 && left < right) {
                left++;
            }
            while (A[right] % 2 != 0 && left < right) {
                right--;
            }
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{4, 2, 1, 3})));
    }

}
