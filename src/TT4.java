import java.util.Scanner;

public class TT4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(valid(nums));
    }

    public static int valid(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if ((nums[i] | 0b01111111) == 0b01111111) {
                i++;
            } else if ((nums[i] & 0b11100000) == 0b11000000) {
                if (i + 1 >= nums.length) {
                    return 0;
                }
                for (int j = 1; j <= 1; j++) {
                    if ((nums[i + j] & 0b11000000) != 0b10000000) {
                        return 0;
                    }
                }
                i += 2;
            } else if ((nums[i] & 0b11110000) == 0b11100000) {
                if (i + 2 >= nums.length) {
                    return 0;
                }
                for (int j = 1; j <= 2; j++) {
                    if ((nums[i + j] & 0b11000000) != 0b10000000) {
                        return 0;
                    }
                }
                i += 3;
            } else if ((nums[i] & 0b11111000) == 0b11110000) {
                if (i + 3 >= nums.length) {
                    return 0;
                }
                for (int j = 1; j <= 3; j++) {
                    if ((nums[i + j] & 0b11000000) != 0b10000000) {
                        return 0;
                    }
                }
                i += 4;
            } else {
                return 0;
            }
        }
        return 1;
    }


}
