public class Q1012 {
    public static void main(String[] args) {
        System.out.println(new Q1012().bitwiseComplement(0));
        System.out.println(new Q1012().bitwiseComplement(2));
        System.out.println(new Q1012().bitwiseComplement(1));
        System.out.println(new Q1012().bitwiseComplement(5));
        System.out.println(new Q1012().bitwiseComplement(7));
        System.out.println(new Q1012().bitwiseComplement(10));
    }

    public int bitwiseComplement(int N) {
        int result = 0;
        int i;
        for (i = 31; i >= 0; i--) {
            if ((1 << i & N) != 0) {
                break;
            }
        }
//        System.out.println(i);
        for (; i >= 0; i--) {
            if ((1 << i & N) == 0) {
                result |= (1 << i);
            }
        }
        return N == 0 ? 1 : result;
    }
}
