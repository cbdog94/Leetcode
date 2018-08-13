import java.util.*;

public class Q554 {

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> row : wall) {
            int start = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                start += row.get(i);
                int count = map.getOrDefault(start, 0);
                count++;
                max = Math.max(count, max);
                map.put(start, count);
            }
        }
        return wall.size() - max;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 2, 1));
        list.add(Arrays.asList(3, 1, 2));
        list.add(Arrays.asList(1, 3, 2));
        list.add(Arrays.asList(2, 4));
        list.add(Arrays.asList(3, 1, 2));
        list.add(Arrays.asList(1, 3, 1, 1));
        System.out.println(leastBricks(list));
    }

}
