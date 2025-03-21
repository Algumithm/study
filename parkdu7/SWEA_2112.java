import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K;
	static int grid[][];
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cs = Integer.parseInt(br.readLine());
		
		for (int c = 1; c <= cs; c++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			grid = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 0);
			
			System.out.println("#" + c + " " + min);
		}//case
	}//main
	
	static void dfs(int idx, int cnt) {
		if(min <= cnt) {
			return;
		}
		if(idx == D) {
			if(check()) {
				min = Math.min(min, cnt);
			}
			return;
		}

		//약품투입안함
		dfs(idx + 1, cnt);
		
		int temp[] = grid[idx].clone();
		
		//A투입
		for (int i = 0; i < W; i++) {
			grid[idx][i] = 0;
		}
		dfs(idx + 1, cnt + 1);
		
		//B투입
		for (int i = 0; i < W; i++) {
			grid[idx][i] = 1;
		}
		dfs(idx + 1, cnt + 1);
		
		//되돌리기
		grid[idx] = temp;
	}
	
	
	static boolean check() {
		for (int j = 0; j < W; j++) {
            boolean pass = false;
            for (int i = 0; i <= D - K; i++) {
                int cnt = 1;
                for (int k = i + 1; k < i + K; k++) {
                    if (grid[k][j] == grid[k-1][j]) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                if (cnt >= K) {
                    pass = true;
                    break;
                }
            }
            if (!pass) return false;
        }
        return true;
	}//check
}//swea
