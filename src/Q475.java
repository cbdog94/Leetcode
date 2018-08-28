import java.util.Arrays;

public class Q475 {

    public static void main(String[] args) {
        System.out.println(new Q475().findRadius(new int[]{1, 1, 1, 1, 1, 1, 999, 999, 999, 999, 999}, new int[]{499, 500, 501}));
//        System.out.println(new Q475().findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
//        System.out.println(new Q475().findRadius(new int[]{1, 2, 3, 7, 8}, new int[]{3, 6}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int size = 1;
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] != houses[i - 1]) {
                houses[size++] = houses[i];
            }
        }
        houses = Arrays.copyOf(houses, size);
        int l = 0, r = Math.max(houses[houses.length - 1] - houses[0], Math.max(houses[houses.length - 1] - heaters[0], heaters[heaters.length - 1] - houses[0])), mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (valid(houses, heaters, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            System.out.println(l);
        }
        return l;
    }

    private boolean valid(int[] houses, int[] heaters, int r) {
        int left = 0;
        for (int heater : heaters) {
            int index = Arrays.binarySearch(houses, heater - r);
            if (index < 0) {
                index = -index - 1;
            }
            if (index > left) {
                return false;
            }
            index = Arrays.binarySearch(houses, heater + r);
            if (index < 0) {
                index = -index - 1;
            } else {
                index++;
            }
            if (index >= houses.length) {
                return true;
            }
            left = index;
        }
        return false;
    }
}
