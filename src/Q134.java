public class Q134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, min = Integer.MAX_VALUE, mini = -1;
        for (int i = 0; i < gas.length; i++) {
            int tmp = gas[i] - cost[i];
            sum += tmp;
            if (sum < min) {
                min = sum;
                mini = i;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return (mini + 1) % gas.length;
    }

}
