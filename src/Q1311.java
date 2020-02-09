import java.util.*;

public class Q1311 {
    public static void main(String[] args) {
        System.out.println(new Q1311().watchedVideosByFriends(Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C"), Arrays.asList("B", "C"), Arrays.asList("D")), new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 2));
        System.out.println(new Q1311().watchedVideosByFriends(Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C"), Arrays.asList("B", "C"), Arrays.asList("D")), new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 1));
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<String, Integer> map = null;
        Set<Integer> visited = new HashSet<>();
        List<Integer> ids = Collections.singletonList(id);
        visited.add(id);
        for (int i = 0; i < level; i++) {
            List<Integer> t = new ArrayList<>();
            map = new HashMap<>();
            for (int id_ : ids) {
                int[] friend = friends[id_];
                for (int f : friend) {
                    if (!visited.contains(f)) {
//                        System.out.println(i + " " + f);
                        for (String video : watchedVideos.get(f)) {
                            map.put(video, map.getOrDefault(video, 0) + 1);
                        }
                        visited.add(f);
                        t.add(f);
                    }
                }
            }
            ids = t;
        }
//        Set<Map.Entry<String, Integer>> set = new TreeSet<>((x, y) -> {
//            if (!x.getValue().equals(y.getValue())) {
//                return x.getValue() - y.getValue();
//            }
//            return x.getKey().compareTo(y.getKey());
//        });
//        set.addAll(map.entrySet());
        List<String> res = new ArrayList<>(map.keySet());
        Map<String, Integer> finalMap = map;
        res.sort((x, y) -> {
            int vx = finalMap.get(x);
            int vy = finalMap.get(y);
            if (vx != vy) {
                return vx - vy;
            }
            return x.compareTo(y);
        });
        return res;
    }
}
