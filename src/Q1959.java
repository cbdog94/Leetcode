import java.util.*;

public class Q1959 {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set =new HashSet<>();
        for(int num:nums){
            if(queue.isEmpty()||num>queue.peek()&&!set.contains(num)){
                queue.offer(num);
                set.add(num);
            }
            if(queue.size()>k+1){
                queue.poll();
            }
        }
        System.out.println(queue.peek());
        int cur=queue.poll();
        int sum=0;
        for(int num:nums){
            if(cur<num){
                cur=queue.poll();
            }
            sum+=cur-num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Q1959().minSpaceWastedKResizing(new int[]{10,20,15,30,20}, 2));
    }
}
