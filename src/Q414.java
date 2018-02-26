/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class Q414 {
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i : nums) {
            if (i == Integer.MIN_VALUE) {
                flag = true;
            }
            if (i == first || i == second || i == third)
                continue;
            if (i > first) {
                third = second;
                second = first;
                first = i;
            } else if (i > second) {
                third = second;
                second = i;
            } else if (i > third) {
                third = i;
            }
        }
        if (flag) {
            if (second == Integer.MIN_VALUE)
                return first;
            else
                return third;
        }

        return third == Integer.MIN_VALUE ? first : third;
    }

//    if (nums == null || nums.length == 0)
//            return -1;
//    long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
//        for (int num : nums) {
//        if (num > first) {
//            third = second;
//            second = first;
//            first = num;
//        } else if (num < first && num > second) {
//            third = second;
//            second = num;
//        } else if (num < second && num > third) {
//            third = num;
//        }
//    }
//        if (third == Long.MIN_VALUE)
//            return (int) first;
//        return (int) third;

    public static void main(String[] args) {
        System.out.println(new Q414().thirdMax(new int[]{3, 2, 1}));
        System.out.println(new Q414().thirdMax(new int[]{1, 2}));
        System.out.println(new Q414().thirdMax(new int[]{2, 2, 3, 1}));
    }
}
