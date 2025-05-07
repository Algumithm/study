import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static char[] a;
    static int b;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        a = strs[0].toCharArray();
        b = Integer.parseInt(strs[1]);

        visited = new boolean[a.length];
        dfs("");

        System.out.println(max);
    }
  
    public static void dfs(String cur) {
        if (cur.length() == a.length) {
            if (cur.charAt(0) == '0') return;
            int val = Integer.parseInt(cur);
            if (val < b) {
                max = Math.max(max, val);
            }
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cur + a[i]);
                visited[i] = false;
            }
        }
    }
}
