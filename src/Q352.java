import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Q352 {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class SummaryRanges {

        TreeMap<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            map = new TreeMap<>();
        }

        public void addNum(int val) {
            Map.Entry<Integer, Integer> floor = map.floorEntry(val), ceil = map.ceilingEntry(val);
            if (floor != null) {
                if (floor.getValue() == val - 1) {
                    if (ceil != null && ceil.getKey() == val + 1) {
                        map.put(floor.getKey(), ceil.getValue());
                        map.remove(ceil.getKey());
                    } else {
                        map.put(floor.getKey(), val);
                    }
                } else if (floor.getValue() < val - 1) {
                    if (ceil != null && ceil.getKey() == val + 1) {
                        map.put(val, ceil.getValue());
                        map.remove(ceil.getKey());
                    } else {
                        map.put(val, val);
                    }
                }
            } else {
                if (ceil != null && ceil.getKey() == val + 1) {
                    map.put(val, ceil.getValue());
                    map.remove(ceil.getKey());
                } else {
                    map.put(val, val);
                }
            }
        }

        public List<Interval> getIntervals() {
            List<Interval> result = new ArrayList<>(map.size());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                result.add(new Interval(entry.getKey(), entry.getValue()));
            }
            return result;
        }
    }

}
