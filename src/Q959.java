public class Q959 {


    public static void main(String[] args) {
        System.out.println(new Q959().regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(new Q959().regionsBySlashes(new String[]{" /", "  "}));
        System.out.println(new Q959().regionsBySlashes(new String[]{"\\/", "/\\"}));
        System.out.println(new Q959().regionsBySlashes(new String[]{"/\\", "\\/"}));
        System.out.println(new Q959().regionsBySlashes(new String[]{"//", "/ "}));
    }

    public int regionsBySlashes(String[] grid) {
        int[][] graph = new int[grid.length * 3][grid.length * 3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '\\') {
                    graph[i * 3][j * 3] = graph[i * 3 + 1][j * 3 + 1] = graph[i * 3 + 2][j * 3 + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    graph[i * 3 + 2][j * 3] = graph[i * 3 + 1][j * 3 + 1] = graph[i * 3][j * 3 + 2] = 1;
                }
            }
        }
        int regions = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 0) {
                    dfs(graph, i, j);
                    regions++;
                }
            }
        }
        return regions;
    }

    private void dfs(int[][] graph, int i, int j) {
        if (i < 0 || i >= graph.length || j < 0 || j >= graph.length) {
            return;
        }
        if (graph[i][j] != 0) {
            return;
        }
        graph[i][j] = 2;
        dfs(graph, i, j + 1);
        dfs(graph, i, j - 1);
        dfs(graph, i + 1, j);
        dfs(graph, i - 1, j);
    }
}
