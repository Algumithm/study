package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725 {   // 실버2_트리의 부모찾기
    static int n;             
    static int[][] arr;      
    static int[] parent;   
    static boolean[] visited; 
    static Queue<Integer> queue;
    static List<Integer>[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());  
        tree = new List[n+1];
        for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Integer>();
		}
        parent = new int[n + 1];   
        visited = new boolean[n + 1]; 
        queue = new LinkedList<>();


        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        queue.offer(1);      
        visited[1] = true;  

        while (!queue.isEmpty()) {
            int cur = queue.poll(); 

            for(int nxt : tree[cur]) {
            	if(!visited[nxt]) {
            		visited[nxt] = true;
            		queue.offer(nxt);
            		parent[nxt] = cur;
            	}
            }

        }

        // 2번 노드부터 부모를 출력
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        
        System.out.println(sb);

        br.close();
    }
}
