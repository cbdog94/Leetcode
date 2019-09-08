import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Unity3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = scanner.nextInt();
        }
        int[] braves = brave(num);
        for (int i = 0; i < braves.length; i++) {
            if (i == 0) {
                System.out.print(braves[i]);
            } else {
                System.out.print(" " + braves[i]);
            }
        }
    }

    private static int[] brave(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = Collections.binarySearch(list, nums[i]);
            if (index < 0) {
                index = -index - 1;
                list.add(index, nums[i]);
                nums[i] = index;
            } else {
                int j;
                for (j = index - 1; j >= 0; j--) {
                    if (list.get(j) < list.get(j + 1)) {
                        break;
                    }
                }
                list.add(j + 1, nums[i]);
                nums[i] = j + 1;
            }
        }
        return nums;
    }
}
