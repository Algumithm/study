package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14889 {
	static int grid[][];
	static int N;
    static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		grid = new int[N][N];
        visited = new boolean[N];
        
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

        pairing(0, 0);
        System.out.println(min);
	}
	
	static void pairing(int idx, int count) {
        if (count == N / 2) {
        	System.out.println("visited: ");
        	for (int i = 0; i < visited.length; i++) {
				System.out.print(visited[i] + " ");
			}System.out.println();
            calculate();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pairing(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

	
	static void calculate() {
        int startTeam = 0, linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    System.out.println("스타트 i :" + i + " j: " + j);
                    System.out.println("grid[i][j] , grid[j][i]" + grid[i][j] + ", "+ grid[j][i]);
                    startTeam += grid[i][j] + grid[j][i];
                } else if (!visited[i] && !visited[j]) { 
                    System.out.println("링크 i :" + i + " j: " + j);
                    System.out.println("grid[i][j] , grid[j][i]" + grid[i][j] + ", "+ grid[j][i]);
                    linkTeam += grid[i][j] + grid[j][i];
                }
            }
        }
//        System.out.println("startTeam : " + startTeam);
//        System.out.println("linkTeam : " + linkTeam);
        min = Math.min(min, Math.abs(startTeam - linkTeam));
    }
}
