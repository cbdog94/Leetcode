import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tencent3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = scanner.nextInt();
        }
        count(arrays);
    }

    private static void count(int[] arrays) {
        List<Integer> tmp = new ArrayList<>();
        int[] left = new int[arrays.length], right = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            int index = Collections.binarySearch(tmp, arrays[i]);
            if (index < 0) {
                index = -index - 1;
                tmp = new ArrayList<>(tmp.subList(index, tmp.size()));
                tmp.add(0, arrays[i]);
            } else {
                tmp = new ArrayList<>(tmp.subList(index, tmp.size()));
            }


            left[i] = tmp.size();
        }
        tmp.clear();
        for (int i = arrays.length - 1; i >= 0; i--) {
            int index = Collections.binarySearch(tmp, arrays[i]);
            if (index < 0) {
                index = -index - 1;
                tmp = new ArrayList<>(tmp.subList(index, tmp.size()));
                tmp.add(0, arrays[i]);
            } else {
                tmp = new ArrayList<>(tmp.subList(index, tmp.size()));
            }
            right[i] = tmp.size();
        }
        for (int i = 0; i < arrays.length; i++) {
            if (i == 0) {
                System.out.print(right[i + 1] + 1);
            } else if (i < arrays.length - 1) {
                System.out.print(" " + (1 + left[i - 1] + right[i + 1]));
            } else {
                System.out.print(" " + (1 + left[i - 1]));
            }
        }
    }

}
