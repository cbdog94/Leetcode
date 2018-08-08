public class Q299 {

    public static String getHint(String secret, String guess) {
        char[] sc = secret.toCharArray(), gc = guess.toCharArray();
        int[] count = new int[10];
        int A = 0, B = 0;
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == gc[i]) {
                A++;
                sc[i] = 0;
            } else {
                count[sc[i] - '0']++;
            }
        }

        for (int i = 0; i < gc.length; i++) {
            if (sc[i] != 0 && count[gc[i] - '0'] != 0) {
                count[gc[i] - '0']--;
                B++;
            }
        }
        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }

}
