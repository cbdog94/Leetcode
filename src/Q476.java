public class Q476 {

    public static void main(String[] args) {
        System.out.println(Integer.highestOneBit(16));
    }

    public int findComplement(int num) {
        return ~num & (Integer.highestOneBit(num) - 1 << 1 | 1);
    }

}
