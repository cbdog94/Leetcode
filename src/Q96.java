public class Q96 {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    /**
     * G(n)=F(1,n)+F(2,n)+...+F(n,n)
     * F(i,n)=G(i-1)*G(n-i)
     */
    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)
                G[i] += G[j - 1] * G[i - j];
        return G[n];
    }
}
