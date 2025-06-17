class Solution {
    static boolean[] visited;
    static int[][] computers;
    static int n;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        Solution.n = n;
        Solution.computers = computers;
        visited = new boolean[n]; 

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        return answer;
    }

    public void DFS(int v) {
        visited[v] = true;

        for (int i = 0; i < n; i++) {
            if (computers[v][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }
}
