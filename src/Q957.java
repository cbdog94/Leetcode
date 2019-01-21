import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q957 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q957().prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
        System.out.println(Arrays.toString(new Q957().prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] map = new int[1 << 8];
        List<Integer> list = new ArrayList<>();
        Arrays.fill(map, -1);
        map[convert(cells)] = 0;
        list.add(convert(cells));
//        System.out.println(Arrays.toString(cells));
        for (int i = 1; i <= N; i++) {
            int[] tmp = Arrays.copyOf(cells, 8);
            cells[0] = cells[7] = 0;
            for (int j = 1; j <= 6; j++) {
                if (tmp[j - 1] == tmp[j + 1]) {
                    cells[j] = 1;
                } else {
                    cells[j] = 0;
                }
            }
//            System.out.println(Arrays.toString(cells));
            int converted = convert(cells);
            if (map[converted] == -1) {
                map[converted] = i;
                list.add(converted);
            } else {
                return revert(list.get(map[converted] + (N - map[converted]) % (i - map[converted])));
            }
        }
        return cells;
    }

    private int convert(int[] cells) {
        int result = 0;
        result |= cells[0];
        result |= (cells[1] << 1);
        result |= (cells[2] << 2);
        result |= (cells[3] << 3);
        result |= (cells[4] << 4);
        result |= (cells[5] << 5);
        result |= (cells[6] << 6);
        result |= (cells[7] << 7);
        return result;
    }

    private int[] revert(int converted) {
        int[] result = new int[8];
        result[0] = (converted & 1);
        result[1] = ((converted >>> 1) & 1);
        result[2] = ((converted >>> 2) & 1);
        result[3] = ((converted >>> 3) & 1);
        result[4] = ((converted >>> 4) & 1);
        result[5] = ((converted >>> 5) & 1);
        result[6] = ((converted >>> 6) & 1);
        result[7] = ((converted >>> 7) & 1);
        return result;
    }
}
