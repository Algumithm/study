import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        
        visited = new boolean[n];
        
        for(int k = 0; k < n; k++){
            
            if(!visited[k]) {
                q.add(k);
                answer++;
            }

            while(!q.isEmpty()){
                int cur = q.poll();
                visited[cur] = true;
                
                for(int i = 0; i < computers.length ; i++){
                    if(!visited[i] && computers[cur][i] == 1){
                        q.add(i);
                    }
                }
            }
        }
        
        return answer;
    }
}
