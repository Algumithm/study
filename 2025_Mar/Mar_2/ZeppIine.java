import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int result;
	static int[][] matrix;
	static int[] perm;
	static boolean[] visited;
	
	static void trip(int depth, int cost, int prev){
		if(depth == size) {
			if(matrix[perm[size-1]][perm[0]] != 0) {
				perm[size] = perm[0];
				int temp = 0;
				for(int i = 0; i < size; i++) {
					temp += matrix[perm[i]][perm[i+1]];
				}
				result = Math.min(temp, result);
			}
			return;
		}
		
		for(int i = 0; i < size; i++) {
			if(!visited[i] && matrix[prev][i] != 0) {
				visited[i] = true;
				perm[depth] = i;
				trip(depth+1, cost+matrix[prev][i], i);
				perm[depth] = -1;
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		
		matrix = new int[size][size];
		perm = new int[size+1];
		visited = new boolean[size];
		result = Integer.MAX_VALUE;
		
		for(int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i <= size; i++) {
			perm[i] = -1;
		}
		
		trip(0, 0, 0);
		
		System.out.println(result);
		br.close();
	}
}
