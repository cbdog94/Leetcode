import java.util.LinkedList;
import java.util.Queue;

public class Q207 {

    public static void main(String[] args) {
        Q207 q = new Q207();
        System.out.println(q.canFinish(4, new int[][]{{1, 0}, {0, 2}, {1, 2}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (graph[pre][i]) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

}
