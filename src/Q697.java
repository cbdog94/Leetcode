public class Q697 {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    public static int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int[] position1 = new int[50000];
        int[] position2 = new int[50000];
        int maxCount = 0;
        int minLength = 50001;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            count[n]++;
            if (position1[n] == position2[n]) {
                position1[n] = i;
                position2[n] = i + 1;
            } else {
                position2[n] = i + 1;
            }
            if (count[n] > maxCount || count[n] == maxCount && position2[n] - position1[n] < minLength) {
                maxCount = count[n];
                minLength = position2[n] - position1[n];
            }
        }
        return minLength;
    }
}
