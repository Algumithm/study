import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
    static int[][] network;
    static int num;
    static boolean[] visited;
    static int count;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        num = n;
        network = computers;
        visited = new boolean[num];
        
        for(int i = 0; i < num; i++){
            count = 0;
            bfs(i);
            if(count >= 1){
                answer++;
                n -= count;
            }
            if(n == 0){
                break;
            }
        }
        return answer;
    }
    
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList();
        if(!visited[start]){
            q.add(start);
            visited[start] = true;
            count++;
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i < num; i++){
                if(cur != i && network[cur][i] == 1){
                    if(!visited[i]){
                        q.add(i);
                        visited[i] = true;
                        count++;
                    }
                }
            }
        }
    }
}
