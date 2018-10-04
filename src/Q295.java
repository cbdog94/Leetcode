import java.util.PriorityQueue;

public class Q295 {

    class MedianFinder {

        PriorityQueue<Integer> min, max;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>();
        }

        public void addNum(int num) {
            min.offer(num);
            max.offer(-min.poll());
            if (min.size() < max.size()) {
                min.offer(-max.poll());
            }
        }

        public double findMedian() {
            if (min.size() > max.size()) {
                return min.peek();
            } else {
                return (min.peek() - max.peek()) * 1.0 / 2;
            }
        }
    }

}
