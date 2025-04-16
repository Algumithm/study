import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int V, E;
    static List<node>[] graph;
    static int[] dist;

    static class node {
        int v, e;
        public node(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[u].add(new node(v, e));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        di(start);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }
        bw.flush();
    }

    static void di(int start) {
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        pq.add(new node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            node cur = pq.poll();
            if (dist[cur.v] < cur.e) continue;

            for (node next : graph[cur.v]) {
                if (dist[next.v] > dist[cur.v] + next.e) {
                    dist[next.v] = dist[cur.v] + next.e;
                    pq.add(new node(next.v, dist[next.v]));
                }
            }
        }
    }
}
