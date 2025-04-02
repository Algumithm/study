import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int arr[];
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		max = Integer.MIN_VALUE; 
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		
		System.out.println(max);
	}//main
	
	static void dfs(int idx, int cnt, int manjok) {
		if(manjok >= K) {
			cnt += manjok - K;
			manjok = 0; //만족도에서 에너지 추출 후 초기화
		}
		if(idx == N) {
			max = Math.max(max, cnt);
			return;
		}
		
		//선택
		dfs(idx + 1, cnt, manjok + arr[idx]);
		
    //만족도 0일때만 선택 안할 수 있음
		if(manjok == 0) {
			//선택안함
			dfs(idx + 1, cnt, manjok);
		}
	}
}
