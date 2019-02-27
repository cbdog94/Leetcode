public class Q991 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1000000000));
        System.out.println(new Q991().brokenCalc(2, 3));
        System.out.println(new Q991().brokenCalc(5, 8));
        System.out.println(new Q991().brokenCalc(3, 10));
        System.out.println(new Q991().brokenCalc(1024, 1));
        System.out.println(new Q991().brokenCalc(1, 1000000000));
    }

    public int brokenCalc(int X, int Y) {
        int result = 0;
        while (Y > X) {
            result++;
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
        }
        return result + X - Y;
    }
}
