import java.util.PriorityQueue;

import java.util.*;
class Q5839 {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>((x,y)->y-x);
        int sum=0;
        for(int p:piles){
            sum+=p;
            queue.offer(p);
        }
        for(int i=0;i<k;i++){
            int t = queue.poll();
            sum -= t/2;
            queue.offer(t-t/2);
        }

        return sum;
    }
}