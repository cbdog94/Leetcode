import java.util.LinkedList;

public class Q622 {

    class MyCircularQueue {

        int cur = 0;
        int size;
        LinkedList<Integer> list;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            size = k;
            list = new LinkedList<>();
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (cur == size) {
                return false;
            }
            list.add(value);
            cur++;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (cur == 0) {
                return false;
            }
            list.remove(0);
            cur--;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (cur == 0) {
                return -1;
            }
            return list.getFirst();
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (cur == 0) {
                return -1;
            }
            return list.getLast();
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return cur == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return cur == size;
        }
    }

}
