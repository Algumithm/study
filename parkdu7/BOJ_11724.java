import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int N, M;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start); 
        }
//        for (int i = 0; i < graph.size(); i++) {
//        	System.out.print("i : " + i + " / ");
//			for (int j = 0; j < graph.get(i).size(); j++) {
//				System.out.print(graph.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
//        System.out.println();

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt += bfs(i);
            }
        }

        System.out.println(cnt);
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return 1;
    }
}
