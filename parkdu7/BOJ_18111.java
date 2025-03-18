import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, B, min[];
	static int[][] grid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        min = new int[]{Integer.MAX_VALUE, -1};
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        int time[] = new int[257];
        for (int i = 0; i < time.length; i++) {
        	int floor = B;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					int temp = i - grid[j][k];
					if(temp < 0) {
						time[i] += -temp * 2;
						floor += -temp;
					}
					else {
						time[i] += temp;
						floor -= temp;
					}
				}
			}
			if(floor >= 0) {
				if(min[0] >= time[i]) {
				    min[0] = time[i];
				    min[1] = i;
				}
			}
		}
        
        System.out.println(min[0] + " " + min[1]);
	}//main
}
