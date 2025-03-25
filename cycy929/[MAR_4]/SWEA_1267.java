package study0327;

import java.util.Scanner;

public class Solution0325_작업순서 {
    
    static int V, E; 
    static int[][] graph; // 인접행렬
    static int[] visited; // 방문

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            V = sc.nextInt();
            E = sc.nextInt();

            graph = new int[V + 1][V + 1]; // 그래프 인접행렬 2차원 배열
            visited = new int[V + 1]; // 방문 여부 배열
            
            for (int i = 0; i < E; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[b][a] = 1; // b->a
            }

            System.out.println("#" + test_case + " ");
            
            // 방문 전인 정점부터 재귀 시작
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }

            System.out.println();
        }
        
        sc.close();
    }
    
    static void dfs(int a) {
        visited[a] = 1; 
        
        for (int i = 1; i <= V; i++) {
            // 현재 정점연결되고, 방문 전이면 탐색
            if (graph[a][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
        
        //정점 출력
        System.out.print(a + " ");
    }
}
