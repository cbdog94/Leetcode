/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 */
public class Q45 {


    public static int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int step = 0;
        int start = 0, end = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (i + nums[i] >= nums.length - 1)
                return step + 1;
            if (i == end) {
                start = end + 1;
                end = max;
                step++;
            }
        }
        return step;
    }


//    public static void trackback(int[] nums, int start, int step) {
//        if (step > min)
//            return;
//        if (start >0) {
//            for(int i=start-1;i>=0;i--){
//                if(start-i<=nums[i]){
//                    trackback(nums,i,step+1);
//                }
//            }
//        } else if (start == 0) {
//            min = Math.min(min, step);
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{1, 1, 1, 2}));
        System.out.println(jump(new int[]{1, 2, 1, 1}));
        System.out.println(jump(new int[]{3, 3, 1, 2}));
        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5}));
    }
}
