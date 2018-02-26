/**
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * 分析：水桶问题，水桶有两个挡板，装水的容量与短的挡板有关
 * 首先计算最远的两块挡板能装的水，如果左挡板低于右挡板，那么计算左挡板右边的那块挡板与右挡板之间能装的水
 * 为什么要这样做？因为装水的容量与较短的那块挡板有关
 */
public class Q11 {
//    public static int maxArea(int[] height) {
//        int area = -1;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int temp = (j - i) * Math.min(height[i], height[j]);
//                if (temp > area)
//                    area = temp;
//            }
//        }
//        return area;
//    }

    //O(n)
    public static int maxArea(int[] height) {

        int j = height.length - 1, i = 0, mx = 0;

        while (i < j) {
            mx = Math.max(mx, ((j - i) * (Math.min(height[i], height[j]))));

            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return mx;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{1, 2, 3, 4}));
        System.out.println(maxArea(new int[]{2, 5, 3, 1, 4}));
    }
}
