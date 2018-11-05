import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q936 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Q936().movesToStamp("abc", "ababc")));
//        System.out.println(Arrays.toString(new Q936().movesToStamp("abca", "aabcaca")));
//        System.out.println(Arrays.toString(new Q936().movesToStamp("e", "eeeeeeee")));
        System.out.println(Arrays.toString(new Q936().movesToStamp("zjmhy", "zmjzjzjmhy")));
    }

    public int[] movesToStamp(String stamp, String target) {
        char[] sc = stamp.toCharArray(), tc = target.toCharArray();
        char[] aim = new char[tc.length];
        Arrays.fill(aim, '?');
        List<Integer> result = new ArrayList<>();

        while (!Arrays.equals(tc, aim)) {
            int index = remove(sc, tc);
            if (index == -1) {
                return new int[]{};
            }
            result.add(0, index);
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    private int remove(char[] sc, char[] tc) {
        int j;
        boolean flag;
        for (int i = 0; i < tc.length - sc.length + 1; i++) {
            flag = false;
            for (j = 0; j < sc.length; j++) {
                if (tc[i + j] != '?' && tc[i + j] != sc[j]) {
                    break;
                } else if (tc[i + j] == sc[j]) {
                    flag = true;
                }
            }
            if (j == sc.length && flag) {
                for (j = 0; j < sc.length; j++) {
                    tc[i + j] = '?';
                }
                return i;
            }
        }
        return -1;
    }
}
