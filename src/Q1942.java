import java.util.*;

public class Q1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        Queue<int[]> leavings = new PriorityQueue<int[]>((x,y)->x[0]-y[0]);
        Queue<Integer> availSeats = new PriorityQueue<>();
        int targetStart = times[targetFriend][0];
        Arrays.sort(times, (x,y)-> x[0]-y[0]);
        int currentSeat = 0;
        for(int i=0;i<times.length;i++){
            int start=times[i][0], leave = times[i][1];
            while(!leavings.isEmpty()&&leavings.peek()[0]<=start){
                //int[] temp=leavings.poll();
                availSeats.offer(leavings.poll()[1]);
            }
            int seat;
            if(availSeats.isEmpty()){
                seat=currentSeat++;
            }else{
                seat=availSeats.poll();
            }
            if(start==targetStart){
                return seat;
            }
            leavings.offer(new int[]{leave,seat});
        }

        return currentSeat;
    }

    public static void main(String[] args) {
        System.out.println(new Q1942().smallestChair(new int[][]{{1,4},{2,3},{4,6}}, 1));
        System.out.println(new Q1942().smallestChair(new int[][]{{3,10},{1,5},{2,6}}, 0));
    }
}
