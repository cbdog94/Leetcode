import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Q715 {
    class RangeModule {

        TreeMap<Integer, Integer> map;

        public RangeModule() {
            map = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> l = map.floorEntry(left);
            if (l != null && l.getValue() >= left) {
                left = l.getKey();
            }
            int rightMost = right;
            for (int r : map.subMap(left, true, right, true).values()) {
                rightMost = Math.max(r, rightMost);
            }
            map.keySet().removeAll(new HashSet<>(map.subMap(left, true, right, true).keySet()));
            map.put(left, rightMost);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> l = map.floorEntry(left);
            return l != null && l.getValue() >= right;
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> r = map.floorEntry(right);
            if (r != null && r.getValue() > right) {
                map.put(right, r.getValue());
            }
            Map.Entry<Integer, Integer> l = map.floorEntry(left);
            if (l != null && l.getValue() > left) {
                map.put(l.getKey(), left);
            }
            map.keySet().removeAll(new HashSet<>(map.subMap(left, right).keySet()));
        }
    }
}
