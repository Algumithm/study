
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] grid;
	static int max, N;
	static int[] order;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        order = new int[9];
        visited = new boolean[9];
        
        visited[0] = true;
        order[3] = 0;
        // 1번 선수는 4번 타자
        permutation(0);
        
        System.out.println(max);
	}//main
    
    static void permutation(int cnt) {
        if (cnt == 9) {
        	playBall();
            return;
        }

        if (cnt == 3) {
            permutation(cnt + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    } //순열
    
    static void playBall() {
    	int score = 0;
    	int idx = 0;
    	//////////////////////////////////////////////////////////////////
    	///
    	///
    	///					  1
    	///	
    	///			      2				 0
    	///				\		      /
    	/// 			  	 \		     /
    	/// 				  \		   /
    	///				   \	      	 /
    	///				     \		/
    	///
    	for (int i = 0; i < N; i++) {
            int out = 0;
            boolean[] base = new boolean[3];
            
            while(out < 3) {
            	int batter = order[idx];
            	int result = grid[i][batter];
            	
            	switch(result) {
            	case 0:
            		out++;
            		break;
            	case 1:
            		if(base[2]) {
            			base[2] = false;
            			score++;
            		}
            		if(base[1]) {
            			base[2] = true;
            			base[1] = false;
            		}
            		if(base[0]) {
            			base[1] = true;
            			base[0] = false;
            		}
            		base[0] = true;
            		break;
            	case 2:
            		if(base[2]) {
            			base[2] = false;
            			score++;
            		}
            		if(base[1]) {
            			base[1] = false;
            			score++;
            		}
            		if(base[0]) {
            			base[2] = true;
            			base[0] = false;
            		}
            		base[1] = true;
            		break;
            	case 3:
            		if(base[2]) {
            			base[2] = false;
            			score++;
            		}
            		if(base[1]) {
            			base[1] = false;
            			score++;
            		}
            		if(base[0]) {
            			base[0] = false;
            			score++;
            		}
            		base[2] = true;
            		break;
            	case 4:
            		int total = 0;
            		if(base[2]) total++;
            		if(base[1]) total++;
            		if(base[0]) total++;
            		base[2] = false;
            		base[1] = false;
            		base[0] = false;
            		total++;
            		score += total;
            		break;
            	}
            	
                idx = (idx + 1) % 9;
            }// 3아웃 될때까지 while

    	}
    	
        max = Math.max(max, score);
    }//play
    
}//bj
