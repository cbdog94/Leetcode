import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q658 {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = Arrays.binarySearch(arr, x), left, right;
        if (index < 0) {
            left = right = -index - 1;
        } else {
            left = index;
            right = index + 1;
            k--;
        }
        while (k > 0) {
            if (left > 0 && right < arr.length) {
                if (x - arr[left - 1] <= arr[right] - x) {
                    left--;
                } else {
                    right++;
                }
            } else if (left == 0) {
                right++;
            } else {
                left--;
            }
            k--;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
//        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4,-1));
//        System.out.println(findClosestElements(new int[]{1,2,3,4,5},1,5));
    }
}
