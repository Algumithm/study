import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Monster {
    int x, y, dist;
    
    Monster(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {
    static int N, M, D;
    static int[][] grid;
    static int max = Integer.MIN_VALUE;
    static boolean visited[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        grid = new int[N][M];
        
        visited = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt( st.nextToken() );
            }
        }
        
        //궁수 배치 경우의 수만큼 BFS 해서 최댓값 갱신
        for (int i = 0; i < M - 2; i++) {
            dfs(i,0);
        }
        
        System.out.println(max);
        
    }//main
    
    static void dfs(int idx, int cnt) { // 궁수 배치 dfs
        if(cnt == 2){
            max = Math.max(max, killEnemy());//max값 갱신 
            return;
        }
        visited[idx] = true;
        
        for (int i = idx + 1; i < M; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
        visited[idx] = false;
        
    }//dfs
    
    static int killEnemy() {
        int[][] tempGrid = copyGrid(grid);
        int[] archers = new int[3];
        
        int archerIdx = 0;
        for (int i = 0; i < M; i++) {
            if (visited[i]) {
                archers[archerIdx++] = i;
            }
        }
        
        int killCount = 0;
        
        for (int turn = 0; turn < N; turn++) {
            boolean[][] killed = new boolean[N][M];
            
            for (int archer : archers) { //죽였는지 확인 하고(중복 가능)
                Monster target = findEnemy(tempGrid, archer);
                
                if (target != null) {
                    killed[target.x][target.y] = true;
                }
            }
            
            for (int i = 0; i < N; i++) { //여기서 한번에 카운트 올리기
                for (int j = 0; j < M; j++) {
                    if (killed[i][j] && tempGrid[i][j] == 1) {
                        tempGrid[i][j] = 0;
                        killCount++;
                    }
                }
            }
            
            down(tempGrid);
        }
        
        return killCount;
    }//killEnemy

    static Monster findEnemy(int[][] grid, int archerCol) {
        Queue<Monster> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        
        queue.offer(new Monster(N-1, archerCol, 1));
        
        int[] dx = {0, -1, 0};
        int[] dy = {-1, 0, 1}; //왼쪽부터
        
        while (!queue.isEmpty()) {
            Monster current = queue.poll();
            
            if (current.x < 0 || current.x >= N || current.y < 0 || current.y >= M) {
                continue;
            }
            
            if (visited[current.x][current.y] || current.dist > D) {
                continue;
            }
            
            visited[current.x][current.y] = true;
            
            if (grid[current.x][current.y] == 1) {
                return current;
            }
            
            for (int i = 0; i < 3; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                queue.offer(new Monster(nx, ny, current.dist + 1));
            }
        }
        
        return null;
    }//findEnemy

    static void down(int[][] grid) {
        for (int j = 0; j < M; j++) {
            grid[N-1][j] = 0;
        }
        
        for (int i = N-1; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = grid[i-1][j];
            }
        }
        
        for (int j = 0; j < M; j++) {
            grid[0][j] = 0;
        }
    }//down
    
    static int[][] copyGrid(int[][] gr){
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = gr[i][j];
            }
        }
        return temp;
    }//copygrid
    
}//bj17135

