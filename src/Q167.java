import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return null;

        //数组有序的话，两边夹，如果和过大减小大的，如果和过小增加小的
//        int[] result = new int[2];
//        int low=0, high = numbers.length-1;
//        while(low<high){
//            if(numbers[low]+numbers[high] == target)
//                break;
//            else if(numbers[low]+numbers[high] > target){
//                high--;
//            }else if(numbers[low]+numbers[high] < target){
//                low++;
//            }
//        }
//        result[0]=low+1;
//        result[1]=high+1;
//        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q167().twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(new Q167().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
