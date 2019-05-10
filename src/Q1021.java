import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1021 {
    public static void main(String[] args) {
        System.out.println(new Q1021().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    public int maxScoreSightseeingPair(int[] A) {
        List<Integer>[] map = new List[1001];
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            if (map[a] == null) {
                map[a] = new ArrayList<>();
            }
            map[a].add(i);
        }
        System.out.println(Arrays.toString(map));
        int max = 0;
        for (int i = 1000; i > 0; i--) {
            if (i + i - 1 <= max) {
                break;
            }
            if (map[i] == null) {
                continue;
            }
            for (int j = i; j > 0; j--) {
                if (i + j - 1 <= max) {
                    break;
                }
                if (map[j] == null) {
                    continue;
                }
                max = Math.max(max, i + j - minDist(map[i], map[j]));
            }
        }
        return max;
    }

    private int minDist(List<Integer> a, List<Integer> b) {
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < a.size() && j < b.size()) {
            if (a.get(i).equals(b.get(j))) {
                i++;
                continue;
            }
            min = Math.min(Math.abs(a.get(i) - b.get(j)), min);
            if (a.get(i) < b.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        while (i < a.size()) {
            if (a.get(i).equals(b.get(j - 1))) {
                i++;
                continue;
            }
            min = Math.min(Math.abs(a.get(i) - b.get(j - 1)), min);
            i++;
        }
        while (j < b.size()) {
            if (a.get(i - 1).equals(b.get(j))) {
                j++;
                continue;
            }
            min = Math.min(Math.abs(a.get(i - 1) - b.get(j)), min);
            j++;
        }
        return min;
    }
}
