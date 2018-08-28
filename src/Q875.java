import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q875 {

    class FreqStack {

        Stack<Integer>[] list;
        Map<Integer, Integer> map;
        int max;

        public FreqStack() {
            list = new Stack[10001];
            map = new HashMap<>();
            max = 0;
        }

        public void push(int x) {
            int fre = map.getOrDefault(x, 0) + 1;
            if (list[fre] == null) {
                list[fre] = new Stack<>();
            }
            list[fre].push(x);
            map.put(x, fre);
            max = Math.max(max, fre);
        }

        public int pop() {
            int result = list[max].pop();
            map.put(result, max - 1);
            if (list[max].empty()) {
                max--;
            }
            return result;
        }
    }
}
