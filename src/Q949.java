public class Q949 {
    public static void main(String[] args) {
        System.out.println(new Q949().largestTimeFromDigits(new int[]{2, 0, 6, 6}));
        System.out.println(new Q949().largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        System.out.println(new Q949().largestTimeFromDigits(new int[]{5, 5, 5, 5}));
    }

    public String largestTimeFromDigits(int[] A) {
        char[] result = new char[5];
        int[] map = new int[10];
        for (int a : A) {
            map[a]++;
        }
        if (backtrace(result, map, 0)) {
            return new String(result);
        }
        return "";
    }

    private boolean backtrace(char[] result, int[] map, int s) {
        int i;
        if (s == 0) {
            for (i = 2; i >= 0; i--) {
                if (map[i] != 0) {
                    result[0] = (char) (i + '0');
                    map[i]--;
                    if (backtrace(result, map, s + 1)) {
                        return true;
                    }
                    map[i]++;
                }
            }
            if (i == -1) {
                return false;
            }
        } else if (s == 1) {
            for (i = result[0] == '2' ? 3 : 9; i >= 0; i--) {
                if (map[i] != 0) {
                    result[1] = (char) (i + '0');
                    map[i]--;
                    if (backtrace(result, map, s + 1)) {
                        return true;
                    }
                    map[i]++;
                }
            }
            if (i == -1) {
                return false;
            }
        } else if (s == 2) {
            result[2] = ':';
            return backtrace(result, map, s + 1);
        } else if (s == 3) {
            for (i = 5; i >= 0; i--) {
                if (map[i] != 0) {
                    result[3] = (char) (i + '0');
                    map[i]--;
                    if (backtrace(result, map, s + 1)) {
                        return true;
                    }
                    map[i]++;
                }
            }
            if (i == -1) {
                return false;
            }
        } else if (s == 4) {
            for (i = 9; i >= 0; i--) {
                if (map[i] != 0) {
                    result[4] = (char) (i + '0');
                    map[i]--;
                    return true;
                }
            }
            if (i == -1) {
                return false;
            }
        }
        return false;
    }
}
