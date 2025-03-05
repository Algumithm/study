import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static ArrayList<Integer> result;
    static HashMap<Integer, Integer> map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        int x = Integer.parseInt(strs[3]);
        
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new ArrayList<>();
        map = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int j = 0; j < m; j++) {
            strs = br.readLine().split(" ");
            graph[Integer.parseInt(strs[0])].add(Integer.parseInt(strs[1]));
        }
        
        bfs(x, k);
        
        for (int b = 1; b <= n; b++) {
            if (map.containsKey(b) && map.get(b) == k) {
                result.add(b);
            }
        }
        
        result.sort(null);
        if (!result.isEmpty()) {
            for (int a : result) {
                System.out.println(a);
            }
        } else {
            System.out.println(-1);
        }
    } // main
    
    static void bfs(int start, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        map.put(start, 0);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDistance = map.get(node);
            
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    map.put(next, currentDistance + 1);
                }
            }
        }
    }
} // Test
