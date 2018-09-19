public class Q904 {

    public static int totalFruit(int[] tree) {
        int t1 = -1, t2 = -1;
        int c1 = 0, c2 = 0, tmp1 = 0, tmp2 = 0;
        int max = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == t1) {
                c1++;
                tmp2 = c2;
            } else if (tree[i] == t2) {
                c2++;
                tmp1 = c1;
            } else {
                max = Math.max(c1 + c2, max);
                if (i != 0 && tree[i - 1] == t1) {
                    t2 = tree[i];
                    c1 = c1 - tmp1;
                    c2 = 1;
                    tmp1 = c1;
                    tmp2 = 0;
                } else {
                    t1 = t2;
                    t2 = tree[i];
                    c1 = c2 - tmp2;
                    c2 = 1;
                    tmp1 = c1;
                    tmp2 = 0;
                }
            }
//            System.out.println(tmp1+" "+tmp2+" "+c1 +" "+ c2);
        }
        max = Math.max(c1 + c2, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

}
