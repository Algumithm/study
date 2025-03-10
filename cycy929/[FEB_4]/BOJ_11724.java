import java.util.Scanner;

public class Main_11724 {  
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        
        int components = 0;
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                components++;
            }
        }
        
        System.out.println(components);
        sc.close();
    }
    
    static void dfs(int node) {
        visited[node] = true;
        
        for (int i = 1; i <= n; i++) {
            if (arr[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
