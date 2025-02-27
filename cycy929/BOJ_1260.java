package dfs_bfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260 { // DFS(재귀 함수)와 BFS(큐를 사용한 탐색) - 정점번호 작은것을 먼저 방문, 더 이상 방문할 수 있는점이 없을경우 종료.(정점은 1~n)

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 정점 개수
        int M = sc.nextInt();   // 간선 개수
        int V = sc.nextInt();   // 시작 정점 번호 

        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(); // 정점 a
            int b = sc.nextInt(); // 정점 b
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println();
        sc.close();
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        if (v == arr.length) return;
        for (int j = 1; j < arr.length; j++) {
      
            if (arr[v][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 1; i < arr.length; i++) {
                if (arr[n][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}
