import java.util.Arrays;
import java.util.Scanner;

public class PDD1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] ss = s.split(";");
        String[] numString = ss[0].split(",");
        int n = Integer.parseInt(ss[1]);
        Integer[] nums = new Integer[numString.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numString[i]);
        }
        Arrays.sort(nums, (o1, o2) -> {
            if (o1 % 2 == 0 && o2 % 2 == 0 || o1 % 2 != 0 && o2 % 2 != 0) {
                return o2 - o1;
            } else if (o1 % 2 == 0) {
                return -1;
            } else {
                return 1;
            }
        });
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(nums[i]);
            } else {
                System.out.print("," + nums[i]);
            }
        }
    }

}
