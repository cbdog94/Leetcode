import java.util.HashSet;
import java.util.Set;

public class Q939 {
    /*
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> row = new HashMap<>();
        int result = Integer.MAX_VALUE;
        for (int[] point : points) {
            if (!row.containsKey(point[0])) {
                row.put(point[0], new ArrayList<>());
            }
            row.get(point[0]).add(point[1]);
        }
        List<Integer> rowList = new ArrayList<>(row.keySet());
        for (int i = 0; i < rowList.size(); i++) {
            if (row.get(rowList.get(i)).size() < 2) {
                continue;
            }
            for (int j = i + 1; j < rowList.size(); j++) {
                if (row.get(rowList.get(j)).size() < 2) {
                    continue;
                }
                int rowLength = Math.abs(rowList.get(i) - rowList.get(j));
                List<Integer> colList = row.get(rowList.get(i));
                List<Integer> colList2 = row.get(rowList.get(j));

                for (int k = 0; k < colList.size(); k++) {
                    if (!colList2.contains(colList.get(k))) {
                        continue;
                    }
                    for (int m = k + 1; m < colList.size(); m++) {
                        if (colList2.contains(colList.get(m))) {
                            result = Math.min(result, rowLength * Math.abs(colList.get(k) - colList.get(m)));
                        }
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }*/

    public static void main(String[] args) {
        System.out.println(new Q939().minAreaRect(new int[][]{{3, 2}, {0, 0}, {3, 3}, {3, 4}, {4, 4}, {2, 1}, {4, 3}, {1, 0}, {4, 1}, {0, 2}}));
    }

    public int minAreaRect(int[][] points) {
        Set<Integer> set = new HashSet<>();
        for (int[] point : points) {
            set.add(point[0] * 40001 + point[1]);
        }
//        System.out.println(set);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] point1 = points[i], point2 = points[j];
//                System.out.println(Arrays.toString(point1)+" "+Arrays.toString(point2));
//                System.out.println(point1[0]*40001+point2[1]+" "+(point2[0]*40001+point1[1]));
                if (set.contains(point1[0] * 40001 + point2[1]) && set.contains(point2[0] * 40001 + point1[1]) && point1[0] != point2[0] && point1[1] != point2[1]) {
//                    System.out.println("OK");
                    result = Math.min(result, Math.abs(point1[1] - point2[1]) * Math.abs(point1[0] - point2[0]));
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
