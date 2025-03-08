import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int cnt;
    static int r, c;
    static int ans = -1;
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, N);
        
        dfs(0, 0, size);
        
        bw.write(ans + "\n");
        bw.flush();
    }
    
    static void dfs(int row, int col, int size) {
    	if(r < row || r > row+size || c < col || c> col+size) {
    		cnt += size*size;
    		return;
    	}
    	if(size == 2) {
    		for(int i = row; i < row + 2; i++) {
    			for(int j = col; j < col + 2; j++) {
    				if(i == r && j == c) ans = cnt;
    				cnt++;
    			}
    		}
    		return;
    	}
    	dfs(row, col, size/2);
    	dfs(row, col+size/2, size/2);
    	dfs(row+size/2, col, size/2);
    	dfs(row+size/2, col+size/2, size/2);
    }
}
