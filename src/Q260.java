import java.util.Arrays;

public class Q260 {

    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int i = 0;
        while (((xor >> i) & 1) != 1) {
            i++;
        }
        int mask = 1 << i;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & mask) == mask) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2})));
    }

}
