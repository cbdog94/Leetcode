public class Q330 {

    public static int minPatches(int[] nums, int n) {
        long miss = 1;
        int add = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                add++;
            }
        }
        return add;
    }

    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1, 3}, 6));
        System.out.println(minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(minPatches(new int[]{1, 2, 2}, 5));
    }

}