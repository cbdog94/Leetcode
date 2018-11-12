public class Q405 {

    public String toHex(int num) {
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        long tmp = num;
        if (tmp < 0) {
            tmp = ((long) 1 << 32) + tmp;
        } else if (tmp == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (tmp != 0) {
            sb.append(map[(int) (tmp % 16)]);
            tmp /= 16;
        }
        return sb.reverse().toString();
    }
}
