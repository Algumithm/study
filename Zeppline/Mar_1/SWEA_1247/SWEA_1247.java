import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int COUNT;
	static int RESULT;
	static int[] COMPANY;
	static int[] HOME;
	static int[][] POSITION;
	static boolean[] VISITED;
	
	static int getPath(int[] prev, int[] next) {
		return Math.abs(prev[0]-next[0]) + Math.abs(prev[1]-next[1]);
	}
	
	static void findShortPath(int pCount, int path, int lastPoint) {
		if(path > RESULT) return;
		
		if(pCount == COUNT) {
			int homePath = path + getPath(POSITION[lastPoint], HOME);
			path += homePath;
			RESULT = Math.min(RESULT, homePath);
			return;
		}
		
		for(int i = 0; i < COUNT; i++) {
			if(!VISITED[i]) {
				VISITED[i] = true;
				int curPath = path + getPath(POSITION[lastPoint], POSITION[i]);
				findShortPath(pCount+1, curPath, i);
				VISITED[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			COUNT = Integer.parseInt(br.readLine());
			RESULT = Integer.MAX_VALUE;
			
			COMPANY = new int[2];
			HOME = new int[2];
			
			POSITION = new int[COUNT][2];
			VISITED = new boolean[COUNT];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			COMPANY[0] = Integer.parseInt(st.nextToken());
			COMPANY[1] = Integer.parseInt(st.nextToken());
			
			HOME[0] = Integer.parseInt(st.nextToken());
			HOME[1] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < COUNT; i++) {
				POSITION[i][0] = Integer.parseInt(st.nextToken());
				POSITION[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < COUNT; i++) {
				VISITED[i] = true;
				int comPath = getPath(COMPANY, POSITION[i]);
				findShortPath(1, comPath, i);
				VISITED[i] = false;
			}
			
			System.out.println("#" + test_case + " " + RESULT);
		}
		br.close();
	}
}
