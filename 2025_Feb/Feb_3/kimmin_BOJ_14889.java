import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int SIZE;
	static int[][] POTENTIAL;
	static int[] PERSON;
	static int[] PERM;
	static int RESULT;
	static boolean[] VISITED;
	
	static void makeTeam(int size) {
		if(RESULT == 0) return;
		
		if(size == SIZE) {
			RESULT = Math.min(RESULT, teamPotential());
			return;
		}
		
		for (int i = 0; i < SIZE; i++) {
            if (!VISITED[i]) { 
            	VISITED[i] = true;
            	PERM[size] = i;
                makeTeam(size + 1);
                VISITED[i] = false;
            }
        }
	}
	
	static int teamPotential() {
		int start = 0;
		int link = 0;
		
		for(int i = 0; i < SIZE/2; i++) {
			for(int j = i+1; j < SIZE/2; j++) {
				start += POTENTIAL[PERM[i]][PERM[j]];
				start += POTENTIAL[PERM[j]][PERM[i]];
			}
		}
		
		for(int i = SIZE/2; i < SIZE; i++) {
			for(int j = i+1; j < SIZE; j++) {
				link += POTENTIAL[PERM[i]][PERM[j]];
				link += POTENTIAL[PERM[j]][PERM[i]];
			}
		}
		
		return Math.abs(start - link);
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SIZE = Integer.parseInt(br.readLine());
		
		POTENTIAL = new int[SIZE][SIZE];
		RESULT = Integer.MAX_VALUE;
		PERSON = new int[SIZE];		
		PERM = new int[SIZE];
		VISITED = new boolean[SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			PERSON[i] = i;
		}
		
		for(int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < SIZE; j++) {
				POTENTIAL[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeTeam(0);
		
		System.out.println(RESULT);
		
		br.close();
	}
}
