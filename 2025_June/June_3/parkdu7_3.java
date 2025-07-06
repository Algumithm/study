import java.util.*;

class Solution {
    static final int N = 4;
    static final int[][] dxdy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int min = Integer.MAX_VALUE;
    static List<Integer> cardList = new ArrayList<>();

    public int solution(int[][] board, int x, int y) {
        boolean[] existCard = new boolean[7];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] != 0 && !existCard[board[i][j]]) {
                    existCard[board[i][j]] = true;
                    cardList.add(board[i][j]);
                }

        boolean[] visited = new boolean[cardList.size()];
        permutation(visited, new ArrayList<>(), board, x, y);
        return min;
    }

    void permutation(boolean[] visited, List<Integer> list, int[][] board, int x, int y) {
        if (list.size() == cardList.size()) {
            dfs(list, 0, x, y, board, 0);
            return;
        }

        for (int i = 0; i < cardList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(cardList.get(i));
                permutation(visited, list, board, x, y);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    void dfs(List<Integer> list, int idx, int x, int y, int[][] board, int cnt) {
        if(cnt >= min)
            return;
        
        if (idx == list.size()) {
            min = Math.min(min, cnt);
            return;
        }

        int card = list.get(idx);
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] == card)
                    pos.add(new int[]{i, j});

        int[] first = pos.get(0); int[] second = pos.get(1);

        int firstToSecond = 
            bfs(x, y, first[0], first[1], board)
            + bfs(first[0], first[1], second[0], second[1], board)
            + 2;

        int secondToFirst = 
            bfs(x, y, second[0], second[1], board)
            + bfs(second[0], second[1], first[0], first[1], board)
            + 2;

        int[][] newBoard = copyBoard(board);
        newBoard[first[0]][first[1]] = 0;
        newBoard[second[0]][second[1]] = 0;
        
        // 첫번째 먼저 제거한 경우
        dfs(list, idx + 1, second[0], second[1], newBoard, cnt + firstToSecond);
        // 두번째 먼저 제거한 경우
        dfs(list, idx + 1, first[0], first[1], newBoard, cnt + secondToFirst);
    }

    int bfs(int startX, int startY, int desX, int desY, int[][] board) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0}); // x, y, cnt
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], cnt = cur[2];

            if (x == desX && y == desY) return cnt;

            // 한칸 이동
            for (int[] d : dxdy) {
                int nx = x + d[0], ny = y + d[1];
                if (!isEdge(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cnt + 1});
                }
            }

            // Ctrl 이동
            for (int[] d : dxdy) {
                int nx = x, ny = y;
                while (true) {
                    int mx = nx + d[0], my = ny + d[1];
                    if (isEdge(mx, my)) break; // 벽이면 막힘
                    nx = mx; ny = my;
                    if (board[nx][ny] != 0) break; // 카드면 막힘
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return 0;
    }

    boolean isEdge(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                newBoard[i][j] = board[i][j];
        return newBoard;
    }
}
