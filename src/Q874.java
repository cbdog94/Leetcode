import java.util.HashSet;
import java.util.Set;

public class Q874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        int x = 0, y = 0, cur = 0;
        int result = 0;
        int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int command : commands) {
            if (command == -1) {
                cur = (cur + 1) % 4;
            } else if (command == -2) {
                cur = (cur + 4 - 1) % 4;
            } else {
                int[] cd = d[cur];
                while (command > 0 && !set.contains((x + cd[0]) + "," + (y + cd[1]))) {
                    x += cd[0];
                    y += cd[1];
                    command--;
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}
