import java.util.ArrayList;
import java.util.List;

public class Q901 {

    public static void main(String[] args) {
        Q901 q = new Q901();
        StockSpanner stockSpanner = q.new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

    class StockSpanner {
        List<Integer> list;
        List<Integer> ans;

        public StockSpanner() {
            list = new ArrayList<>();
            ans = new ArrayList<>();
        }

        public int next(int price) {
            int index = list.size() - 1;
            int count = 1;
            while (index >= 0 && list.get(index) <= price) {
                count += ans.get(index);
                index -= ans.get(index);
            }
            list.add(price);
            ans.add(count);
            return count;
        }
    }

}
