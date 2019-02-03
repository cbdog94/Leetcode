import java.util.*;

public class Q981 {
    class TimeMap {

        Map<String, List<String>> valueMap;
        Map<String, List<Integer>> timeMap;

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            valueMap = new HashMap<>();
            timeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!valueMap.containsKey(key)) {
                valueMap.put(key, new ArrayList<>());
                timeMap.put(key, new ArrayList<>());
            }
            valueMap.get(key).add(value);
            timeMap.get(key).add(timestamp);
        }

        public String get(String key, int timestamp) {
            if (!valueMap.containsKey(key)) {
                return "";
            }
            int index = Collections.binarySearch(timeMap.get(key), timestamp);
            if (index < 0) {
                index = -index - 2;
            }
            if (index < 0) {
                return "";
            }
            return valueMap.get(key).get(index);
        }
    }
}
