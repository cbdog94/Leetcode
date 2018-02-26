import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n,
 * find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 */
public class Q229 {

//    public List<Integer> majorityElement(int[] nums) {
//        List<Integer> result = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : nums) {
//            int times = map.getOrDefault(i, 0);
//            times++;
//            if (times == nums.length / 3 + 1)
//                result.add(i);
//            map.put(i, times);
//        }
//        return result;
//    }

    //https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    //majority vote algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        int c1 = 0, c2 = 0;
        int count1 = 0, count2 = 0;
        for (int i : nums) {
            if (count1 == 0 && c2 != i)
                c1 = i;
            if (count2 == 0)
                c2 = i;

            if (c1 == i)
                count1++;
            else if (c2 == i)
                count2++;
            else {
                count1--;
                count2--;
            }
            System.out.println(c1 + " " + c2);
            System.out.println(count1 + " " + count2);
            System.out.println("------");
        }
        count1 = 0;
        count2 = 0;
//        System.out.println(c1+" "+c2);
        for (int i : nums) {
            if (i == c1)
                count1++;
            else if (i == c2)
                count2++;
        }
        if (count1 > nums.length / 3)
            result.add(c1);
        if (count2 > nums.length / 3)
            result.add(c2);
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Q229().majorityElement(new int[]{1, 2, 3, 3, 3, 3, 2, 2}));
        System.out.println(new Q229().majorityElement(new int[]{1, 2, 2, 3, 2, 1, 1, 3}));
    }

}
