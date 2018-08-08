import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int fre = entry.getValue();
            if (list[fre] == null) {
                list[fre] = new ArrayList<>();
            }
            list[fre].add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        for (int i = list.length - 1; i >= 0 && result.size() < k; i--) {
            if (list[i] != null) {
                result.addAll(list[i]);
            }
        }
        return result;
    }

}
