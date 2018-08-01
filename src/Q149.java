import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q149 {

    public static void main(String[] args) {
        Q149 q = new Q149();
        System.out.println(q.gcd(-1, 2));
        System.out.println(q.gcd(0, 1));
        System.out.println(q.maxPoints(new Point[]{q.new Point(2, 3), q.new Point(3, 3), q.new Point(-5, 3)}));
    }

    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int max = 0;

        HashMap<String, Integer> countMap = new HashMap<>();
        List<Point> single = new ArrayList<>();
        for (Point point : points) {
            String tmp = point.x + " " + point.y;
            int count = countMap.getOrDefault(tmp, 0) + 1;
            if (!countMap.containsKey(tmp)) {
                single.add(point);
            }
            countMap.put(tmp, count);
            max = Math.max(max, count);
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < single.size(); i++) {
            Map<String, Integer> curMap = new HashMap<>();
            for (int j = i + 1; j < single.size(); j++) {
                int gcd = gcd(single.get(j).y - single.get(i).y, single.get(j).x - single.get(i).x);
                String k = single.get(j).x == single.get(i).x ? "Nan" : (single.get(j).y == single.get(i).y ? "0" : (single.get(j).y - single.get(i).y) / gcd + " " + (single.get(j).x - single.get(i).x) / gcd);
                if (!map.containsKey(k)) {
                    int tmp = curMap.getOrDefault(k, countMap.get(single.get(i).x + " " + single.get(i).y)) + countMap.get(single.get(j).x + " " + single.get(j).y);
                    max = Math.max(max, tmp);
                    curMap.put(k, tmp);
                }
            }
            map.putAll(curMap);
        }
        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
