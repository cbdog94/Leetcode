public class Q706 {
    class MyHashMap {

        int bucket = 1001;
        int buckItem = 1000;
        int[][] map;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            map = new int[bucket][];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int row = hash(key);
            if (map[row] == null) {
                map[row] = new int[buckItem];
            }
            map[row][offset(key)] = value == 0 ? -2 : value;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int row = hash(key);
            if (map[row] == null) {
                return -1;
            }
            int num = map[row][offset(key)];
            if (num == 0) {
                return -1;
            } else if (num == -2) {
                return 0;
            } else {
                return num;
            }
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int row = hash(key);
            if (map[row] == null) {
                return;
            }
            map[row][offset(key)] = 0;
        }

        private int hash(int key) {
            return key / buckItem;
        }

        private int offset(int key) {
            return key % buckItem;
        }
    }
}
