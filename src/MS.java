import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MS {

    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(12,new int[]{3, 6, 2, 1, 9, 8, 5, 7, 4, 6, 5, 4}));
            System.out.println(lengthOfLIS(3,new int[][]{{1,2},{4,10},{20,21},{2,23}}));
//        System.out.println(lengthOfLIS(2,new int[]{3,6}));
    }

//    public static int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, 1);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > nums[0])
//                for (int j = 0; j < i; j++)
//                    if (nums[j] > nums[i])
//                        dp[i] = Math.max(dp[i], dp[j] + 1);
//        }
//        int max = 0;
//        for (int i : dp)
//            max = Math.max(max, i);
//        return max;
//    }

    public static int lengthOfLIS(int numOfPlant,int[] plantHeight) {
        int count = 0;
        boolean[] flag = new boolean[numOfPlant];
//        List<Integer> list=new LinkedList<>();
        List<Integer> remove = new ArrayList<>();
//        for(int i:nums){
//            list.add(i);
//        }
        for (int i = 0; i < numOfPlant; i++) {
            boolean hasRemove = false;
            int last = plantHeight[0];
//            System.out.println(Arrays.toString(flag));
            for (int j = 1; j < numOfPlant; j++) {
                if (!flag[j]&&plantHeight[j] > last) {
                    remove.add(j);
                    hasRemove = true;
                }
                if (!flag[j])
                    last = plantHeight[j];
            }
            if (hasRemove) {
                count++;
            } else {
                break;
            }
            for (int j : remove)
                flag[j] = true;
            remove.clear();
        }
        return count;
    }

    public static int lengthOfLIS(int numOfDays,int[][] taskList) {
        if(numOfDays==0)
            return 0;
        int[] dp=new int[numOfDays+1];
        dp[0]=0;
        dp[1]=taskList[0][1];
        for(int i=2;i<=numOfDays;i++){
            dp[i]=Math.max(dp[i-1]+taskList[i-1][0],dp[i-2]+taskList[i-1][1]);
        }
        return dp[numOfDays];
    }

}
