
public class Q900 {
    public static void main(String[] args) {
        Q900 q = new Q900();
        RLEIterator rle = q.new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        System.out.println(rle.next(2));
        System.out.println(rle.next(1));
        System.out.println(rle.next(1));
        System.out.println(rle.next(2));

    }

    class RLEIterator {

        long index = 0;
        int[] A;
        int sIndex = 0;
        long sum = 0;

        public RLEIterator(int[] A) {
            this.A = A;
        }

        public int next(int n) {
            index += n;
            while (index > sum) {
                if (sIndex >= A.length) {
                    return -1;
                }
                sum += A[sIndex];
                sIndex += 2;
            }
            return A[sIndex - 1];
        }
    }
}
