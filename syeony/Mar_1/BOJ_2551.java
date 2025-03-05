import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class g4_2251 {

    static int A, B, C;
    static boolean[][][] isVisited;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        isVisited = new boolean[A + 1][B + 1][C + 1];

        bfs();

        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (Integer i : ans) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, C});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0], b = cur[1], c = cur[2];

            if (isVisited[a][b][c]) continue;
            isVisited[a][b][c] = true;

            if (a == 0) ans.add(c);

            pour(q, a, b, c, B, 0, 1); // A -> B
            pour(q, a, b, c, C, 0, 2); // A -> C
            pour(q, a, b, c, A, 1, 0); // B -> A
            pour(q, a, b, c, C, 1, 2); // B -> C
            pour(q, a, b, c, A, 2, 0); // C -> A
            pour(q, a, b, c, B, 2, 1); // C -> B
        }
    }

    // q: bfs탐색에 사용되는 큐
    // a,b,c: A,B,C의 물의 양
    // toCap: 물을 받을 컵의 최대 확보 공간
    // fromIdx: 물을 보낼 컵의 인덱스
    // toIdx: 물을 받을 컵의 인덱스
    private static void pour(Queue<int[]> q, int a, int b, int c, int toCap, int fromIdx, int toIdx) {
        int[] cur = {a, b, c};
        int pourAmount = Math.min(cur[fromIdx], toCap - cur[toIdx]);
        cur[fromIdx] -= pourAmount;
        cur[toIdx] += pourAmount;
        q.add(new int[]{cur[0], cur[1], cur[2]});
    }

}
