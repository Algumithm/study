import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n;
    static int [][] a;
    static boolean [] visited;
    static int [] tmp;
    static int min;
    static void DFS(int count) { // 백트래킹 시작
    	if(count == n) {  // 경로들을 설정하면 탐색시작 ex) 1-3-4-2-1 순으로 이동한다면 a[1][3] + a[3][4] + a[4][2] + a[2][1]을 더함
    		int sum = 0;
    		for(int i = 0;i<n - 1;i++) {
    			if(a[tmp[i]][tmp[i + 1]] == 0) {
    				return;
    			}
    			sum = sum + a[tmp[i]][tmp[i + 1]];
    		}
    		if(a[tmp[n - 1]][tmp[0]] == 0) {
				return;
			}
    		sum = sum + a[tmp[n - 1]][tmp[0]];
    		if(sum < min) {
    			min = sum;   // 최소값을 찾으라고했으므로
    		}
    		return;
    	}
    	
    	for(int i = 1;i<=n;i++) {
    		if(!visited[i]) {
    			tmp[count] = i;
    			
    			visited[i] = true;
    			DFS(count + 1);
    			visited[i] = false;
    		}
    	}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        a = new int[n + 1][n + 1];
        min = Integer.MAX_VALUE;
        visited = new boolean[n + 1];
        tmp = new int[n];
        for(int i = 1;i<=n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1;j<=n;j++) {
        		a[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        DFS(0);
        System.out.println(min);
  }
}
