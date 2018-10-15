import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q763 {

    public static void main(String[] args) {
        System.out.println(new Q763().partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(new Q763().partitionLabels("aaab"));
    }

    public List<Integer> partitionLabels(String S) {
        char[] c = S.toCharArray();
        int[][] pos = new int[26][2];
        for (int i = 0; i < 26; i++) {
            pos[i][0] = Integer.MAX_VALUE;
            pos[i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < c.length; i++) {
            pos[c[i] - 'a'][0] = Math.min(pos[c[i] - 'a'][0], i);
            pos[c[i] - 'a'][1] = Math.max(pos[c[i] - 'a'][1], i);
        }
        Arrays.sort(pos, Comparator.comparingInt(x -> x[0]));
        List<Integer> group = new ArrayList<>();
        int lastCut = -1, cut = pos[0][1], i;
        for (i = 1; i < 26; i++) {
            if (pos[i][0] > cut) {
                group.add(cut - lastCut);
                lastCut = cut;
                cut = pos[i][1];
            } else if (pos[i][1] > cut) {
                cut = pos[i][1];
            }
            if (pos[i][0] == Integer.MAX_VALUE) {
                break;
            }
        }
        if (pos[i - 1][0] <= cut) {
            group.add(cut - lastCut);
        }
        return group;
    }

}
