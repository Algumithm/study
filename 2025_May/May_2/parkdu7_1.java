import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int grid[][];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < M; y++) {
            dfs(0, y, 0, grid[0][y]);
        }

        System.out.println(min);
    }

    static void dfs(int x, int y, int dir, int sum) {
        if (x == N - 1) {
            min = Math.min(min, sum);
            return;
        }


        // 1 좌하향 , 2 하향, 3 우하향
        if (dir != 1 && !isEdge(x + 1, y - 1)) {
            dfs(x + 1, y - 1, 1, sum + grid[x + 1][y - 1]);
        }
        
        if (dir != 2) {
            dfs(x + 1, y, 2, sum + grid[x + 1][y]);
        }
        
        if (dir != 3 && !isEdge(x + 1, y + 1)) {
            dfs(x + 1, y + 1, 3, sum + grid[x + 1][y + 1]);
        }
    }

    static boolean isEdge(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}
