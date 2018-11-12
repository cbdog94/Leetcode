public class Q201 {

    public static void main(String[] args) {
        System.out.println(new Q201().rangeBitwiseAnd(5, 7));
        System.out.println(new Q201().rangeBitwiseAnd(0, 1));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for (int i = 0; i < 31; i++) {
            int t = n & ~(1 << i);
            t |= (1 << i) - 1;
            if (m > t) {
                result |= 1 << i;
            }
        }
        return result;
    }

}
