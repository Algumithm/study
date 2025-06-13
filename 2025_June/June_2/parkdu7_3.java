import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[][] dxdy = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    static boolean rVisited[][];
    static boolean bVisited[][];
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static int[] rdes, bdes;
    static int grid[][];
    
    public int solution(int[][] maze) {
        int answer = 0;
        n = maze.length;
        m = maze[0].length;
        grid = maze.clone();
        
        rVisited = new boolean[n][m];
        bVisited = new boolean[n][m];
        
        rdes = findDestination(maze, 3);
        bdes = findDestination(maze, 4);
        
        int[] tmp1 = findDestination(maze, 1);
        int[] tmp2 = findDestination(maze, 2);
        
        dfs(0, tmp1[0], tmp1[1], tmp2[0], tmp2[1]);
        if(min == Integer.MAX_VALUE) answer = 0;
        else answer = min; 
        
        return answer;
    }
    
    static void dfs(int cnt, int rx, int ry, int bx, int by){
        if(min < cnt)
            return;
        
        // System.out.println(cnt + " " + rx + " " +  ry + " " +  bx  + " " + by);
        
        if(rx == rdes[0] && ry == rdes[1] && bx == bdes[0] && by == bdes[1]){
            min = Math.min(cnt, min);
            return;
        }
        
        rVisited[rx][ry] = true;
        bVisited[bx][by] = true;
        for (int[] d1 : dxdy) {
            int rnx = rx, rny = ry;
            if (!(rx == rdes[0] && ry == rdes[1])) {
                rnx = rx + d1[0];
                rny = ry + d1[1];
                if (isEdge(rnx, rny) || rVisited[rnx][rny] || grid[rnx][rny] == 5) {
                    continue;
                }
            }

            for (int[] d2 : dxdy) {
                int bnx = bx, bny = by;
                if (!(bx == bdes[0] && by == bdes[1])) {
                    bnx = bx + d2[0];
                    bny = by + d2[1];
                    if (isEdge(bnx, bny) || bVisited[bnx][bny] || grid[bnx][bny] == 5) {
                        continue;
                    }
                }

                if (rnx == bnx && rny == bny) continue;
                if (rnx == bx && rny == by && bnx == rx && bny == ry) continue;

                dfs(cnt + 1, rnx, rny, bnx, bny);
            }
        }
        
        rVisited[rx][ry] = false;
        bVisited[bx][by] = false;
    }
    
    static boolean isEdge(int x, int y){
        return x < 0 || x >= n || y < 0 || y >= m;
    }
    
    static int[] findDestination(int[][] maze, int num){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j] == num){
                    return new int[]{ i, j };
                }
            }
        }
        return null;
    }
}
