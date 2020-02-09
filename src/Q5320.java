import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q5320 {
    public static void main(String[] args) {
        System.out.println(new Q5320().filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 1, 50, 10));
        System.out.println(new Q5320().filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 0, 50, 10));
        System.out.println(new Q5320().filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 0, 30, 3));
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Map<Integer, Integer> map = new HashMap<>(restaurants.length);
        List<Integer> res = new ArrayList<>(restaurants.length);
        for (int i = 0; i < restaurants.length; i++) {
            map.put(restaurants[i][0], i);
            if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                res.add(restaurants[i][0]);
            }
        }
        res.sort((x, y) -> {
            int[] vx = restaurants[map.get(x)], vy = restaurants[map.get(y)];
            if (vx[1] != vy[1]) {
                return vy[1] - vx[1];
            }
            return y - x;
        });
        return res;
    }
}
