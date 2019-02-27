import java.util.TreeMap;

public class Q327 {
    public static void main(String[] args) {
        System.out.println(new Q327().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, 1);
        long sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
//            System.out.println((sum - upper) + " " + (sum - lower + 1));
            for (int c : map.subMap(sum - upper, sum - lower + 1).values()) {
                result += c;
            }
//            System.out.println(result);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
