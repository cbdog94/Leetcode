import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q210 {

    public static void main(String[] args) {
        Q210 q = new Q210();
        System.out.println(Arrays.toString(q.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(q.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int[] row : prerequisites) {
            graph[row[1]][row[0]] = true;
            inDegree[row[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            result[count++] = pre;
            for (int i = 0; i < numCourses; i++) {
                if (graph[pre][i]) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count < numCourses ? new int[0] : result;
    }

}
