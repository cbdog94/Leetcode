import java.util.Arrays;

public class Q66 {

    public static int[] plusOne(int[] digits) {
        int length = digits.length, c = 1;
        int[] result = new int[length + 1];
        for (int i = length; i > 0; i--) {
            result[i] = (digits[i - 1] + c) % 10;
            c = (digits[i - 1] + c) / 10;
        }
        result[0] = c;
        return c == 0 ? Arrays.copyOfRange(result, 1, length + 1) : result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));
    }
}
