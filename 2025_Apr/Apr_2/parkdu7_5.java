import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] grid;
	static int dxdy[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동 남 서 북
	static int dice[] = {2, 1, 5, 6, 4, 3}; // 뒤, 위, 앞, 아래, 왼, 오른
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		////////////////////입력//////////////////////////
		
		int x = 0, y = 0, dir = 0, score = 0;
        for (int i = 0; i < K; i++) {
            int nx = x + dxdy[dir][0];
            int ny = y + dxdy[dir][1];

            // 범위 밖이면 방향 바꾸기
            if (isEdge(nx, ny)) {
                dir = reverseDir(dir);
                nx = x + dxdy[dir][0];
                ny = y + dxdy[dir][1];
            }

            x = nx;
            y = ny;

            rollDice(dir);
            score += bfs(x, y);

            int A = dice[3]; // 아래3
            int B = grid[x][y];

            if (A > B) dir = (dir + 1) % 4;       // 시계방향 회전 (동남서북)
            else if (A < B) dir = (dir + 3) % 4;  // 반시계방향 회전 (동북서남)
        }

        System.out.println(score);
	}//main
	
	static int bfs(int x, int y) { // 이어져있는 같은 수 갯수 찾기
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int cnt = 1;
        int val = grid[x][y]; //놓인 곳의 값

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dxdy) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if (!isEdge(nx, ny) && !visited[nx][ny] && grid[nx][ny] == val) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    cnt++;
                }
            }
        }

        return cnt * val;
    }
	
	static void rollDice(int dir) {
		int[] tmp = dice.clone();
		switch(dir) {
		// 뒤0, 위1, 앞2, 아래3, 왼4, 오른5
		case 0: // 동
			dice[1] = tmp[4]; // 위 <- 왼
			dice[4] = tmp[3]; // 왼 <- 아래
			dice[3] = tmp[5]; // 아래 <- 오른
			dice[5] = tmp[1]; // 오른 <- 위
			break;
		case 1: // 남
			dice[0] = tmp[3]; // 뒤 <- 아래
			dice[3] = tmp[2]; // 아래 <- 앞
			dice[2] = tmp[1]; // 앞 <- 위
			dice[1] = tmp[0]; // 위 <- 뒤
			break;
		case 2: // 서
			dice[1] = tmp[5]; // 위 <- 오른
			dice[5] = tmp[3]; // 오른 <- 아래
			dice[3] = tmp[4]; // 아래 <- 왼
			dice[4] = tmp[1]; // 왼 <- 위
			break;
		case 3: // 북
			dice[0] = tmp[1]; // 뒤 <- 위
			dice[1] = tmp[2]; // 위 <- 앞
			dice[2] = tmp[3]; // 앞 <- 아래
			dice[3] = tmp[0]; // 아래 <- 뒤
			break;
		}
	}//roll
	
	static int reverseDir(int dir) { //방향바꾸기
		int changedDir = 0;
		switch(dir) {
		case 0:
			changedDir = 2;
			break;
		case 1:
			changedDir = 3;
			break;
		case 2:
			changedDir = 0;
			break;
		case 3:
			changedDir = 1;
			break;
		}
		return changedDir;
    }//reverseDir
	
	static boolean isEdge(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= M);
	}//isEdge
}
