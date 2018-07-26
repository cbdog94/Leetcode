public class Q172 {

    public static int trailingZeroes(int n) {
        int result = 0;
        for (int i = 1; i <= Math.floor(Math.log(n) / Math.log(5)); i++) {
            result += n / Math.pow(5, i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(100));
        System.out.println(trailingZeroes(200));
    }
}
