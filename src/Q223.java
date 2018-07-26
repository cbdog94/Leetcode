public class Q223 {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width = 0, height = 0;
        if (E >= A && E <= C) {
            width = Math.min(C - E, G - E);
        } else if (G >= A && G <= C) {
            width = Math.min(G - E, G - A);
        } else if (E <= A && G >= C) {
            width = C - A;
        }

        if (H >= B && H <= D) {
            height = Math.min(H - B, H - F);
        } else if (F >= B && F <= D) {
            height = Math.min(D - F, H - F);
        } else if (F <= B && H >= D) {
            height = D - B;
        }
//        System.out.println(width + " " + height);
        return (C - A) * (D - B) + (H - F) * (G - E) - width * height;
    }

    public static void main(String[] args) {
        System.out.println(computeArea(-2,
                -2,
                2,
                2,
                -3,
                -3,
                3,
                -1));
    }
}
