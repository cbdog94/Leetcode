import java.util.Arrays;
import java.util.List;

public class Q315 {

    /*public List<Integer> countSmaller(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        Integer[] result = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = Collections.binarySearch(tmp, nums[i]);
            if (index < 0) {
                result[i] = -index - 1;
                tmp.add(-index - 1, nums[i]);
            } else {
                while (tmp.get(index) == nums[i]) {
                    index--;
                }
                result[i] = index + 1;
                tmp.add(index + 1, nums[i]);
            }
        }
        return Arrays.asList(result);
    }*/

    Integer[] result;

    public static void main(String[] args) {
        System.out.println(new Q315().countSmaller(new int[]{5, 2, 6, 1}));
    }

    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> tmp = new ArrayList<>();
        result = new Integer[nums.length];
        Arrays.fill(result, 0);
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, nums.length - 1);
        return Arrays.asList(result);
    }

    private void mergeSort(int[] nums, int[] index, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, index, left, mid);
        mergeSort(nums, index, mid + 1, right);
        merge(nums, index, left, right);
    }

    private void merge(int[] nums, int[] index, int left, int right) {
        int mid = left + (right - left) / 2;
        int i = mid, j = right, t = right - left;
        int[] numsT = new int[right - left + 1], indexT = new int[right - left + 1];
        while (j >= mid + 1) {
            while (i >= left && nums[i] > nums[j]) {
                numsT[t] = nums[i];
                indexT[t] = index[i];
                result[index[i]] += j - mid;
                i--;
                t--;
            }
            numsT[t] = nums[j];
            indexT[t] = index[j];
            j--;
            t--;
        }
        while (i >= left) {
            numsT[t] = nums[i];
            indexT[t] = index[i];
            i--;
            t--;
        }
        System.arraycopy(numsT, 0, nums, left, numsT.length);
        System.arraycopy(indexT, 0, index, left, indexT.length);
    }

}
