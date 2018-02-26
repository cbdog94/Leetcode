public class Q84 {

    public static int largestRectangleArea(int[] heights) {
//        int max = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int min = heights[i];
//            for (int j = i; j < heights.length; j++) {
//                min = Math.min(min, heights[j]);
//                max = Math.max(max, (j - i + 1) * min);
//            }
//        }
//        return max;
        return largestRectangleArea(heights, 0, heights.length - 1, 0);
    }

//    O(n)复杂度
//    public static int largestRectangleArea(int[] heights) {
//        Stack<Integer> stack = new Stack<>();
//        int max = 0;
//        for (int i = 0; i <= heights.length; i++) {
//            int h = (i == heights.length ? 0 : heights[i]);
//            if (stack.empty() || heights[stack.peek()] <= h) {
//                stack.push(i);
//            } else {
//                int tp = stack.pop();
//                max = Math.max(max, heights[tp] * (stack.empty() ? i : i - stack.peek() - 1));
//                i--;
//            }
//        }
//        return max;
//
//    }

    private static int largestRectangleArea(int[] heights, int start, int end, int max) {
        if (start == end)
            return heights[start];
        if (start > end)
            return 0;
//        int min = Integer.MAX_VALUE;
//        int index = 0;
//        for (int i = start; i <= end; i++)
//            if (heights[i] < min) {
//                min = heights[i];
//                index = i;
//            }

        //优化部分 判断数组是否升序 如果升序的话停止使用递归
        //？？可能leetcode的测试集
        boolean sorted = true;
        int index = start;

        for (int i = start + 1; i <= end; i++) {
            if (heights[i] < heights[i - 1]) sorted = false;
            if (heights[i] < heights[index]) index = i;
        }
        if (sorted) {
            max = 0;
            for (int i = start; i <= end; i++) {
                max = Math.max(max, heights[i] * (end - i + 1));
            }
            return max;
        }
        //

        max = Math.max(max, (end - start + 1) * heights[index]);
        int lMax = largestRectangleArea(heights, start, index - 1, max);
        int rMax = largestRectangleArea(heights, index + 1, end, max);
        return Math.max(max, Math.max(lMax, rMax));
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{1, 2, 3, 4, 5}));
        System.out.println(largestRectangleArea(new int[]{1}));
        System.out.println(largestRectangleArea(new int[]{}));
        System.out.println(largestRectangleArea(new int[]{5, 4, 3, 2, 1}));
    }

}
