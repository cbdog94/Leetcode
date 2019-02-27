public class Q493 {
    /*public int reversePairs(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[nums.length - 1], 1);
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> floor = map.floorEntry(nums[i] > 0 ? (nums[i] - 1) / 2 : nums[i] / 2 - 1);
            if (floor != null) {
                count += floor.getValue();
            }
            floor = map.floorEntry(nums[i]);
            if (floor != null) {
                map.put(nums[i], floor.getValue() + 1);
            } else {
                map.put(nums[i], 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.tailMap(nums[i], false).entrySet()) {
                map.put(entry.getKey(), entry.getValue() + 1);
            }
//            System.out.println(count);
        }
        return count;
    }*/

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int result = 0;
        result += mergeSort(nums, left, mid);
        result += mergeSort(nums, mid + 1, right);
        result += merge(nums, left, right);
        return result;
    }

    private int merge(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int i = left, j = mid + 1, t = 0;
        int k = mid + 1, result = 0;
        int[] numsT = new int[right - left + 1];
        while (i <= mid) {
            while (j <= right && nums[i] > nums[j]) {
                numsT[t++] = nums[j++];
            }
            while (k <= right && nums[i] > 2L * nums[k]) {
                k++;
            }
            result += k - mid - 1;
            numsT[t++] = nums[i++];
        }
        while (j <= right) {
            numsT[t++] = nums[j++];
        }
        System.arraycopy(numsT, 0, nums, left, numsT.length);
        return result;
    }

}
