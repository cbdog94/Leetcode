import java.util.HashMap;
import java.util.Map;

public class Q447 {

    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point1 : points) {
            for (int[] point2 : points) {
                int distance = (point2[0] - point1[0]) * (point2[0] - point1[0]) + (point2[1] - point1[1]) * (point2[1] - point1[1]);
                int count = map.getOrDefault(distance, 0);
                count++;
                map.put(distance, count);
                if (count > 1) {
                    result += 2 * (count - 1);
                }
            }
            map.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}}));
        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}}));
    }

}
