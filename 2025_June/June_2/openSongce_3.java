import java.util.*;

class Solution {
    static int n, m;
    static int[][] s_maze;
    static int red_sx, red_sy, red_ex, red_ey;
    static int blue_sx, blue_sy, blue_ex, blue_ey;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    // 상태를 나타내는 클래스
    static class State {
        int rx, ry, bx, by, turns;
        boolean[][] visitedR, visitedB;

        State(int rx, int ry, int bx, int by,
              boolean[][] visitedR, boolean[][] visitedB,
              int turns) {
            this.rx = rx; this.ry = ry;
            this.bx = bx; this.by = by;
            this.visitedR = visitedR;
            this.visitedB = visitedB;
            this.turns = turns;
        }
    }

    public int solution(int[][] maze) {
        s_maze = maze;
        n = maze.length;
        m = maze[0].length;

        // 시작/도착 좌표 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                switch (maze[i][j]) {
                    case 1: red_sx = i; red_sy = j; break;
                    case 2: blue_sx = i; blue_sy = j; break;
                    case 3: red_ex = i; red_ey = j; break;
                    case 4: blue_ex = i; blue_ey = j; break;
                }
            }
        }

        // 초기 방문 배열
        boolean[][] initR = new boolean[n][m];
        boolean[][] initB = new boolean[n][m];
        initR[red_sx][red_sy] = true;
        initB[blue_sx][blue_sy] = true;

        Deque<State> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();

        State start = new State(
            red_sx, red_sy, blue_sx, blue_sy,
            initR, initB,
            0
        );
        queue.addLast(start);
        seen.add(makeKey(start));

        while (!queue.isEmpty()) {
            State cur = queue.pollFirst();

            // 둘 다 도착했으면 턴 반환
            if (cur.rx == red_ex && cur.ry == red_ey &&
                cur.bx == blue_ex && cur.by == blue_ey) {
                return cur.turns;
            }

            // 한 턴에 빨강/파랑 각각 네 방향씩 이동
            for (int d1 = 0; d1 < 4; d1++) {
                // 빨간 수레 다음 위치
                int nrx = cur.rx, nry = cur.ry;
                if (!(cur.rx == red_ex && cur.ry == red_ey)) {
                    int tx = cur.rx + dx[d1], ty = cur.ry + dy[d1];
                    if (in(tx, ty)
                        && s_maze[tx][ty] != 5
                        && !cur.visitedR[tx][ty]) {
                        nrx = tx; nry = ty;
                    } else {
                        // 빨강이 이동 못 하면 이 조합은 무시
                        continue;
                    }
                }

                for (int d2 = 0; d2 < 4; d2++) {
                    // 파란 수레 다음 위치
                    int nbx = cur.bx, nby = cur.by;
                    if (!(cur.bx == blue_ex && cur.by == blue_ey)) {
                        int tx2 = cur.bx + dx[d2], ty2 = cur.by + dy[d2];
                        if (in(tx2, ty2)
                            && s_maze[tx2][ty2] != 5
                            && !cur.visitedB[tx2][ty2]) {
                            nbx = tx2; nby = ty2;
                        } else {
                            continue;
                        }
                    }

                    // 1) 동시에 같은 칸 도착 금지
                    if (nrx == nbx && nry == nby) continue;
                    // 2) 자리 교환(swap) 금지
                    if (nrx == cur.bx && nry == cur.by
                     && nbx == cur.rx && nby == cur.ry) continue;

                    // 방문 배열 복사
                    boolean[][] nextR = copy(cur.visitedR);
                    boolean[][] nextB = copy(cur.visitedB);
                    // 새 위치 방문 마킹 (도착 칸은 고정이므로 마킹 생략해도 무방)
                    if (!(nrx == red_ex && nry == red_ey)) nextR[nrx][nry] = true;
                    if (!(nbx == blue_ex && nby == blue_ey)) nextB[nbx][nby] = true;

                    State nxt = new State(
                        nrx, nry, nbx, nby,
                        nextR, nextB,
                        cur.turns + 1
                    );
                    String key = makeKey(nxt);
                    if (seen.add(key)) {
                        queue.addLast(nxt);
                    }
                }
            }
        }

        // 불가능한 경우
        return 0;
    }

    // 상태 비교용 키 생성
    private String makeKey(State s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.rx).append(',').append(s.ry)
          .append(',').append(s.bx).append(',').append(s.by)
          .append('|');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(s.visitedR[i][j] ? '1' : '0');
            }
        }
        sb.append('|');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(s.visitedB[i][j] ? '1' : '0');
            }
        }
        return sb.toString();
    }

    // boolean 배열 복사
    private boolean[][] copy(boolean[][] arr) {
        boolean[][] c = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, c[i], 0, m);
        }
        return c;
    }

    // 격자 범위 확인
    private boolean in(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
