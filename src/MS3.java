public class MS3 {

    public static void main(String[] args) {
        System.out.println(new MS3().is_special(new String[]{"22", "121"}, 2));
        System.out.println(new MS3().is_special(new String[]{"12", "3"}, 2));
    }

    public int is_special(String[] input1, int input2) {
        int count = 0;
        for (String num : input1) {
            if (check(num)) {
                count++;
            }
        }
        return count;
    }

    public boolean check(String numString) {
        long num = Long.parseLong(numString);
        long half = num / 2;
        for (long i = num; i >= half; i--) {
            long reverse = num - i;
            if (new StringBuilder(i + "").reverse().toString().equals(reverse + "")) {
                return true;
            }
        }
        return false;
    }
}