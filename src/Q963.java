import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q963 {

    public static void main(String[] args) {
        System.out.println(new Q963().minAreaFreeRect(new int[][]{{24420, 16685}, {20235, 25520}, {14540, 20845}, {20525, 14500}, {16876, 24557}, {24085, 23720}, {25427, 18964}, {21036, 14573}, {24420, 23315}, {22805, 24760}, {21547, 25304}, {16139, 23952}, {21360, 14645}, {24715, 17120}, {19765, 25520}, {19388, 25491}, {22340, 25005}, {25520, 19765}, {25365, 21320}, {23124, 15443}, {20845, 14540}, {24301, 16532}, {16685, 24420}, {25100, 17875}, {22125, 25100}, {15699, 23468}, {14592, 21131}, {25460, 19155}, {17837, 25084}, {23468, 24301}, {25460, 20845}, {18453, 25304}, {21131, 14592}, {22805, 15240}, {19475, 25500}, {15443, 23124}, {25355, 21360}, {15285, 22880}, {20000, 25525}, {24085, 16280}, {22163, 25084}, {22880, 15285}, {14916, 22163}, {16280, 24085}, {24875, 17400}, {22600, 24875}, {14573, 21036}, {25427, 21036}, {17120, 24715}, {25500, 19475}}));
    }

    public double minAreaFreeRect(int[][] points) {
        Map<String, List<int[]>> map = new HashMap<>();
        double result = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                String center = (points[i][0] + points[j][0]) + "," + (points[i][1] + points[j][1]);
                int distance = squareDist(points[i], points[j]);
                String key = center + "|" + distance;
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                } else {
                    for (int[] line : map.get(key)) {
                        int[] pointX = points[line[0]];
                        result = Math.min(result, Math.sqrt(squareDist(pointX, points[i])) * Math.sqrt(squareDist(pointX, points[j])));
                    }
                }
                map.get(key).add(new int[]{i, j});
            }
        }
        return result == Double.MAX_VALUE ? 0 : result;
    }

    private int squareDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
