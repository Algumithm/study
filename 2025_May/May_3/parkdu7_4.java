import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int[] hasToVisit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int open1 = Integer.parseInt(st.nextToken()) - 1;
        int open2 = Integer.parseInt(st.nextToken()) - 1;

        M = Integer.parseInt(br.readLine());
        hasToVisit = new int[M];
        for (int i = 0; i < M; i++) {
        	hasToVisit[i] = Integer.parseInt(br.readLine()) - 1;
        }

        dfs(open1, open2, 0, 0);
        System.out.println(min);
    }

    static void dfs(int left, int right, int idx, int total) {
    	if(total >= min){
    		return;
    	}
        if (idx == M) {
            min = Math.min(min, total);
            return;
        }

        int target = hasToVisit[idx];

        // 왼쪽 이동
        dfs(target, right, idx + 1, total + Math.abs(left - target));

        // 오른쪽 이동
        dfs(left, target, idx + 1, total + Math.abs(right - target));
    }
}
