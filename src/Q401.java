import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q401 {

    public static void main(String[] args) {
        String[] s1 = new String[]{"0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18", "0:20", "0:24", "0:33", "0:34", "0:36", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08", "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "9:00", "10:00"};
        String[] s2 = new String[]{"3:00", "5:00", "9:00", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "6:00", "10:00", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "12:00", "4:01", "4:02", "4:04", "4:08", "4:16", "4:32", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "0:03", "0:05", "0:09", "0:17", "0:33", "0:06", "0:10", "0:18", "0:34", "0:12", "0:20", "0:36", "0:24", "0:40", "0:48"};
        Arrays.sort(s1);
        Arrays.sort(s2);
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, 0, 0, new boolean[10]);
        return result;
    }

    private void backtrack(List<String> result, int num, int cur, int j, boolean used[]) {
        if (cur == num) {
            int hour = 0, min = 0;
            for (int i = 0; i <= 3; i++) {
                if (used[i]) {
                    hour += 1 << i;
                }
            }
            if (hour >= 12) {
                return;
            }
            for (int i = 4; i <= 9; i++) {
                if (used[i]) {
                    min += 1 << i - 4;
                }
            }
            if (min >= 60) {
                return;
            }
            result.add(hour + ":" + (min < 10 ? "0" + min : min));
            return;
        }
        for (int i = j; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(result, num, cur + 1, i + 1, used);
                used[i] = false;
            }
        }
    }

}
