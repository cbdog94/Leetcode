public class Q525 {
    public static int findMaxLength(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
        int[] map = new int[2 * nums.length + 1];
        int sum = 0, max = 0;
//        map.put(sum, -1);
        map[sum + nums.length] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += (nums[i - 1] == 0 ? -1 : 1);
//            if (map.containsKey(sum)) {
            if (map[sum + nums.length] != 0 || sum == 0) {
//                System.out.println("OK");
//                    max = Math.max(i - map.get(sum), max);
                max = Math.max(i - map[sum + nums.length], max);
            } else {
//                map.put(sum, i);
//                System.out.println(sum);
                map[sum + nums.length] = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 0, 1}));
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{1, 1, 1, 1, 0, 0, 0, 0}));
        System.out.println(findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
    }
}
