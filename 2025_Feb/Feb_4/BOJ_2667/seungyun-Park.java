package _0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj2667 {
    static int grid[][];
    static boolean visited[][];
    static int[][] dxdy = {{-1,0},{1,0},{0,-1},{0,1}};
    static int count;
    static int N;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];
        count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = Character.getNumericValue(st.charAt(j)); 
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    list.add( count );
                }
            }
        }
        
        list.sort(null);
        
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }//main
    
    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int[] d : dxdy) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (!isEdge(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }//dfs
    
    static boolean isEdge(int i, int j) {
        if(i < 0 || i >= N || j < 0 || j >= N) {
            return true;
        }
        return false;
    }//isEdge
}//bj2667
