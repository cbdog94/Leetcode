
import java.util.*;
class Q1976 {

    public int countPaths(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        for(int[] road:roads){
            graph[road[0]][road[1]]=road[2];
            graph[road[1]][road[0]]=road[2];
        }
        Queue<int[]> queue = new PriorityQueue<>((x,y)->x[1]-y[1]);
        int[] dist=new int[n],path=new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] t=queue.poll();
            System.out.println(t[0]+" "+t[1]);
            if(visited[t[0]]){
                continue;
            }
            visited[t[0]]=true;
            for(int i=0;i<n;i++){
                if(graph[t[0]][i]==0){
                    continue;
                }
                if(dist[t[0]]+graph[t[0]][i]<dist[i]){
                    dist[i]=dist[t[0]]+graph[t[0]][i];
                    path[i]=1;
                    queue.offer(new int[]{i,dist[i]});
                }else if(dist[t[0]]+graph[t[0]][i]==dist[i]){
                    path[i]+=path[t[0]];
                }
            }
        }


        return path[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Q1976().countPaths(7,new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
       }
}

