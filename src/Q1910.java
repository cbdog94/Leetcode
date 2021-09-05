import java.util.LinkedList;

public class Q1910 {
    class FrontMiddleBackQueue {

        LinkedList<Integer> front, end;

        public FrontMiddleBackQueue() {
            front = new LinkedList<>();
            end = new LinkedList<>();
        }

        public void pushFront(int val) {
            front.addFirst(val);
            if (front.size() > end.size()) {
                end.addFirst(front.pollLast());
            }
        }

        public void pushMiddle(int val) {
            if (front.size() < end.size()) {
                front.addLast(val);
            } else {
                end.addFirst(val);
            }
        }

        public void pushBack(int val) {
            if (front.size() < end.size()) {
                front.addLast(end.pollFirst());
            }
            end.addLast(val);
        }

        public int popFront() {
            if (front.size() < end.size()) {
                front.addLast(end.pollFirst());
            }

            if (front.isEmpty()) {
                return -1;
            }
            return front.pollFirst();
        }

        public int popMiddle() {
            if (front.size() < end.size()) {
                return end.pollFirst();
            }
            if (front.isEmpty()) {
                return -1;
            }
            return front.pollLast();
        }

        public int popBack() {
            if (front.size() < end.size()) {
                return end.pollLast();
            }
            if (end.isEmpty()) {
                return -1;
            }
            end.addFirst(front.pollLast());
            return end.pollLast();
        }
    }
}
