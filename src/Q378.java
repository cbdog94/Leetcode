public class Q378 {
  /*
    class Tripe implements Comparable<Tripe> {

        int x, y, val;

        Tripe(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tripe o) {
            return this.val - o.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<Tripe> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Tripe(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tripe t = queue.poll();
            if (t.x != n - 1) {
                queue.offer(new Tripe(t.x + 1, t.y, matrix[t.x + 1][t.y]));
            }
        }
        return queue.peek().val;
    }*/

    public static void main(String[] args) {
        System.out.println(new Q378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 1));
        System.out.println(new Q378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 2));
        System.out.println(new Q378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 3));
        System.out.println(new Q378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 4));
        System.out.println(new Q378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 5));
        System.out.println(new Q378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 6));
        System.out.println(new Q378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 7));
        System.out.println(new Q378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println(new Q378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 9));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, column = matrix[0].length;
        int left = matrix[0][0], right = matrix[row - 1][column - 1], mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < column; i++) {
                for (int j = row - 1; j >= 0; j--) {
                    if (matrix[j][i] <= mid) {
                        count += (j + 1);
                        break;
                    }
                }
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
