public class Q765 {

    public static void main(String[] args) {
        System.out.println(new Q765().minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(new Q765().minSwapsCouples(new int[]{3, 2, 0, 1}));
    }

    public int minSwapsCouples(int[] row) {
        int[] index = new int[row.length / 2];
        for (int i = 0; i < row.length; i++) {
            int cp = row[i] / 2;
            index[cp] = Math.max(index[cp], i);
        }
        int count = 0;
        for (int i = 1; i < row.length; i += 2) {
            int curCp = row[i] / 2, lastCp = row[i - 1] / 2;
            if (curCp != lastCp) {
                int t = row[index[lastCp]];
                row[index[lastCp]] = row[i];
                row[i] = t;
                index[curCp] = Math.max(index[curCp], index[lastCp]);
                count++;
            }
        }
        return count;
    }
}
