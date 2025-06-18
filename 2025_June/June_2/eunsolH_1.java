import java.util.*;

class Solution {
    static boolean[] visited;

    static void solve(int node, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                solve(next, graph);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 인접리스트로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        visited = new boolean[n];

        // 네트워크탐색
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                solve(i, graph);
                answer++;
            }
        }

        return answer;
    }
}
