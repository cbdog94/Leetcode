import java.util.*;

public class Q1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length,n=maze[0].length;
        Queue<int[]> queue=new LinkedList<int[]>();
        queue.offer(entrance);
        
        int count = -1;
        while(!queue.isEmpty()){
            for(int i=queue.size();i>0;i--){
                int[] t=queue.poll();
                maze[t[0]][t[1]]='+';
          
                if(t!=entrance&&(t[0]==m-1||t[0]==0||t[1]==0||t[1]==n-1)){
                    return count;
                }
                if(t[0]+1<m && maze[t[0]+1][t[1]]=='.'){
                    queue.offer(new int[]{t[0]+1,t[1]});
                   // System.out.println(1);
                }
                if(t[0]-1>=0 && maze[t[0]-1][t[1]]=='.'){
                    queue.offer(new int[]{t[0]-1,t[1]});
                    //System.out.println(2);
                }
                if(t[1]+1<n && maze[t[0]][t[1]+1]=='.'){
                    queue.offer(new int[]{t[0],t[1]+1});
                    //System.out.println(3);
                }
                if(t[1]-1>=0 && maze[t[0]][t[1]-1]=='.'){
                    queue.offer(new int[]{t[0],t[1]-1});
                   // System.out.println(4);
                }
            }
            
            count++;
            
        }

        return count==0?-1:count;
    }

    public static void main(String[] args) {
        new Q1926().nearestExit(new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}}, new int[]{1,2});
    }
}
