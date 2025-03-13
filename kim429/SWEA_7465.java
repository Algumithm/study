package swea;

import java.util.*;
import java.io.*;
 
public class SWEA_7465 {
	static boolean visited[];
	// ArrayList<Integer> 객체들을 저장하는 배열
	static ArrayList<Integer>[] A;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 1번부터 시작하기 위해서 배열의 크기를 N+1로 지정
			visited = new boolean [N+1];
			A = new ArrayList[N+1];
			
			for(int i = 1; i<N+1; i++) {
				A[i] = new ArrayList<Integer>();
			}
			
			// 왜 A.length 말고 m하는 거지??????????????????
			// m은 간선(연결정보)의 개수인데 A.length 를 하면 노드개수 +1이 됨 (N+1)
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				A[s].add(e);
				A[e].add(s);
			}
			int count = 0;
			for(int i=1; i<N+1; i++) {
				if(!visited[i]) {
					count++;
					DFS(i);
				}
			}
			
			System.out.println("#"+test_case+" "+count);
		}
	}
	
	static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for(int i : A[v]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
}
