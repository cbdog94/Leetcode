
import java.util.*;
class Q5856 {

    //private boolean[] global;
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int res=0;
        boolean[] visited=new boolean[tasks.length];
        //boolean[] resr=new boolean[tasks.length];
        while(!check(visited)){
            res++;
            Object[] t=minDiff(tasks,visited,sessionTime);
            System.out.println(Arrays.toString((boolean[])t[1]));
            visited=Arrays.copyOf((boolean[])t[1], tasks.length);
        }
        return res;
    }
    
    //boolean[] global;
    
    private boolean check(boolean[] visited){
        for(boolean f:visited){
            if(!f){
                return false;
            }
        }
        return true;
    }
    
    private Object[] minDiff(int[] tasks,boolean[] visited,int sessionTime){
        if(sessionTime==0){
            //res=Arrays.copyOf(visited, visited.length);
            return new Object[]{0,Arrays.copyOf(visited, visited.length)};
        }
        boolean flag=false;
        int sum=0;
        for(int i=tasks.length-1;i>=0;i--){
            if(!visited[i]){
                if(sessionTime>=tasks[i]){
                    flag=true;
                }
                sum+=tasks[i];
            }
        }
        if(!flag){
            //res=Arrays.copyOf(visited, visited.length);
            return new Object[]{sessionTime,Arrays.copyOf(visited, visited.length)};
        }
        if(sum<=sessionTime){
            boolean[] t=Arrays.copyOf(visited, visited.length);
            Arrays.fill(t, true);
            return new Object[]{sessionTime-sum,t};
        }

        int min=1000;

        boolean[] minr=Arrays.copyOf(visited, visited.length);
        for(int i=tasks.length-1;i>=0;i--){
                if(!visited[i]&&sessionTime>=tasks[i]){

                    visited[i]=true;
                    Object[] t=minDiff(tasks,visited,sessionTime-tasks[i]);
                    if((int)t[0]<min){
                        //global=Arrays.copyOf(visited, visited.length);
                        minr=(boolean[])t[1];
                        min=(int)t[0];
                    }
                    visited[i]=false;
                }
            }
            if(min==1000){
               // res=minr;
                return new Object[]{sessionTime,minr};
                //return sessionTime;
            }else{
                return new Object[]{min,minr};
            }
        //return min==1000?sessionTime:min;
    }

    public static void main(String[] args) {
        System.out.println(new Q5856().minSessions(new int[]{2,3,3,4,4,4,5,6,7,10}, 12));
        System.out.println(new Q5856().minSessions(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 14));
    }
}