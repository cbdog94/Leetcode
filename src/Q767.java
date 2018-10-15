import java.util.Arrays;
import java.util.PriorityQueue;

public class Q767 {

    public static void main(String[] args) {
        System.out.println(new Q767().reorganizeString("aab"));
        System.out.println(new Q767().reorganizeString("aaab"));
        System.out.println(new Q767().reorganizeString("aaabbbcc"));
    }

    public String reorganizeString(String S) {
        char[] sc = S.toCharArray();
        int[] fre = new int[26];
        for (char c : sc) {
            fre[c - 'a']++;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {
            if (x[1] == y[1]) {
                return x[0] - y[0];
            }
            return y[1] - x[1];
        });
        for (int i = 0; i < 26; i++) {
            if (fre[i] != 0) {
                queue.offer(new int[]{i, fre[i]});
            }
        }
        queue.forEach(x -> System.out.println(Arrays.toString(x)));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            if (sb.length() == 0) {
                sb.append((char) ('a' + t[0]));
                t[1]--;
            } else {
                if (sb.charAt(sb.length() - 1) == 'a' + t[0]) {
                    if (queue.isEmpty()) {
                        return "";
                    } else {
                        int[] t2 = queue.poll();
                        sb.append((char) ('a' + t2[0]));
                        t2[1]--;
                        if (t2[1] != 0) {
                            queue.offer(t2);
                        }
                    }
                } else {
                    sb.append((char) ('a' + t[0]));
                    t[1]--;
                }
            }
            if (t[1] != 0) {
                queue.offer(t);
            }
        }
        return sb.toString();
    }

}
