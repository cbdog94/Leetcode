public class Q705 {

    class MyHashSet {

        int bucket = 1001;
        int buckItem = 1000;
        boolean[][] map;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            map = new boolean[bucket][];
        }

        public void add(int key) {
            int row = hash(key);
            if (map[row] == null) {
                map[row] = new boolean[buckItem];
            }
            map[row][offset(key)] = true;
        }

        public void remove(int key) {
            int row = hash(key);
            if (map[row] == null) {
                return;
            }
            map[row][offset(key)] = false;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int row = hash(key);
            if (map[row] == null) {
                return false;
            }
            return map[row][offset(key)];
        }

        private int hash(int key) {
            return key / buckItem;
        }

        private int offset(int key) {
            return key % buckItem;
        }
    }

}
