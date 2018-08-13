import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q380 {
    class RandomizedSet {

        int size = 0;
        Map<Integer, Integer> map;
        Map<Integer, Integer> reverseMap;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            map = new HashMap<>();
            reverseMap = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (reverseMap.containsKey(val)) {
                return false;
            }
            map.put(size, val);
            reverseMap.put(val, size++);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!reverseMap.containsKey(val)) {
                return false;
            }
            Integer index = reverseMap.remove(val);
            map.remove(index);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int random = new Random().nextInt(size);
            while (!map.containsKey(random)) {
                random = new Random().nextInt(size);
            }
            return map.get(random);
        }
    }


}
