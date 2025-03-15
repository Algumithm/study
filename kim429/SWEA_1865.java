import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] array;
    static double max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            array = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = -1.0; // **초기 max 값을 0이 아니라 -1로 설정**
            dfs(0, 0, 1.0);

            System.out.printf("#%d %.6f%n", test_case, max * 100); // `%%` 제거
        }
    }

    static void dfs(int row, int mask, double prob) {
        // 1. 현재 확률이 0이면 탐색 종료
        if (prob == 0.0) return;

        // 2. 모든 직원이 일을 배정받았다면 최대 확률 갱신
        if (row == N) {
            max = Math.max(max, prob);
            return;
        }

        // 3. 현재 확률이 max보다 작아질 가능성이 높으면 탐색 종료 (백트래킹)
        if (prob <= max) return;

        // 4. 할당할 일 선택 (비트마스크)
        for (int col = 0; col < N; col++) {
            if ((mask & (1 << col)) == 0) { // 아직 선택되지 않은 일(col)이면 선택
                dfs(row + 1, mask | (1 << col), prob * (array[row][col] / 100.0));
            }
        }
    }
}
