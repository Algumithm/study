import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); // 위치, 이동 횟수
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int count = current[1];

            if (position == K) {
                return count;
            }

            // 다음 이동
            int[] nextPositions = { position - 1, position + 1, position * 2 };

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, count + 1});
                }
            }
        }

        return -1;
    }
}
