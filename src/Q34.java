import java.util.Arrays;

/**
 * Created by cbdog94 on 2017/7/17.
 */
public class Q34 {
    public static int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = 0;
        int left = -1, right = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else {
                for (int i = low; i <= mid; i++)
                    if (nums[i] == target) {
                        left = i;
                        break;
                    }
                for (int i = high; i >= mid; i--)
                    if (nums[i] == target) {
                        right = i;
                        break;
                    }
                break;
            }
        }

        return new int[]{left, right};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{8}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{8, 8}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 4}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 4, 5}, 3)));
    }
}
