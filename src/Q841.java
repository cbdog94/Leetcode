import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q841 {

    public static void main(String[] args) {
        System.out.println(new Q841().canVisitAllRooms(Arrays.asList(Collections.singletonList(1), Collections.singletonList(2), Collections.singletonList(3), Collections.emptyList())));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int s, List<List<Integer>> rooms, boolean[] visited) {
        visited[s] = true;
        for (int next : rooms.get(s)) {
            if (!visited[next]) {
                dfs(next, rooms, visited);
            }
        }
    }

}
