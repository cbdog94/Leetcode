import java.util.Arrays;

public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /*
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue=new PriorityQueue<>();
        for(int num:nums){
            queue.offer(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }*/

}
