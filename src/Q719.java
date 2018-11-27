import java.util.Arrays;

public class Q719 {


    public static void main(String[] args) {
        System.out.println(new Q719().smallestDistancePair(new int[]{1, 3, 1, 4}, 1));
        System.out.println(new Q719().smallestDistancePair(new int[]{1, 3, 1, 4}, 2));
        System.out.println(new Q719().smallestDistancePair(new int[]{1, 3, 1, 4}, 3));
        System.out.println(new Q719().smallestDistancePair(new int[]{1, 3, 1, 4}, 4));
        System.out.println(new Q719().smallestDistancePair(new int[]{1, 3, 1, 4}, 5));
        System.out.println(new Q719().smallestDistancePair(new int[]{1, 3, 1, 4}, 6));
    }

    //二分
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0], mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (pos(nums, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    /*
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        for (int i = 0; i < nums.length - 1; i++) {
            queue.offer(new int[]{i, i + 1, nums[i + 1] - nums[i]});
        }
        while (k > 1) {
            int[] t = queue.poll();
            queue.offer(new int[]{t[0], t[1] + 1, t[1] + 1 >= nums.length ? Integer.MAX_VALUE : nums[t[1] + 1] - nums[t[0]]});
            k--;
        }
        return queue.peek()[2];
    }*/

    private int pos(int[] nums, int mid) {
        int result = 0;
        for (int i = 0, j = 0; i < nums.length - 1; i++) {
            while (j < nums.length && nums[j] - nums[i] <= mid) {
                j++;
            }
            result += (j - i - 1);
        }
        return result;
    }
}