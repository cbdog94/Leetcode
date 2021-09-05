
import java.util.*;
class Q5855 {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums,(x,y)->compare(x,y));
        System.out.println(Arrays.toString(nums));
        return nums[nums.length-k];
    }

    private int compare(String x, String y){
        if(x.length()!=y.length()){
            return x.length()-y.length();
        }
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)!=y.charAt(i)){
                return x.charAt(i)-y.charAt(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Q5855().kthLargestNumber(new String[]{"2","21","12","1"}, 3));
    }
}