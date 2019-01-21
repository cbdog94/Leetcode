import java.util.Arrays;

public class Q956 {
    public static void main(String[] args) {
//        System.out.println(new Q956().tallestBillboard(new int[]{1, 2, 3, 6}));
//        System.out.println(new Q956().tallestBillboard(new int[]{1, 2, 3, 4, 5, 6}));
//        System.out.println(new Q956().tallestBillboard(new int[]{1, 2}));
//        System.out.println(new Q956().tallestBillboard(new int[]{3, 4, 3, 3, 2}));
//        System.out.println(new Q956().tallestBillboard(new int[]{96,112,101,100,104,93,106,99,114,81,94}));
        System.out.println(new Q956().tallestBillboard(new int[]{140, 138, 133, 162, 145, 164, 145, 166, 145, 154, 158}));
    }

    public int tallestBillboard(int[] rods) {
        Arrays.sort(rods);
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int max = sum / 2;
        System.out.println(max);
        for (int i = max; i >= 1; i--) {
            boolean[] visited = new boolean[rods.length];
            if (!backtrace(rods, rods.length - 1, i, visited)) {
                continue;
            }
            if (i == 756)
                System.out.println(Arrays.toString(visited));
            if (backtrace(rods, rods.length - 1, i, visited)) {
                return i;
            }
        }
        return 0;
    }

    private boolean backtrace(int[] rods, int s, int sum, boolean[] visited) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }
        for (int i = s; i >= 0; i--) {
            if (!visited[i]) {
                visited[i] = true;
                if (backtrace(rods, i - 1, sum - rods[i], visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
