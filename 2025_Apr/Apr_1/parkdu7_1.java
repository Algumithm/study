import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int max[]; //각각 사람의 최댓값 배열
	static int[][] arr;
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		 
		N = Integer.parseInt(br.readLine());
		max = new int[N];
		arr = new int[N][5];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			max[i] = Integer.MIN_VALUE;
		}
		////////////////입력////////////////////
		
		for (int i = 0; i < N; i++) {
      //N명의 최댓값 구하기
			findMax(i, 0, 0, 0);
		}
		
		int maxIndex = 0;
		int tmax = max[0];
		for (int i = 1; i < N; i++) { //구한 max배열로 우승자 index 찾기
			if( tmax <= max[i] ) {
				tmax = max[i];
				maxIndex = i;
			}
		}
		System.out.println(maxIndex + 1);
		
	}//main
	
	static void findMax(int n, int idx, int cnt, int sum) {
		if(cnt == 3) { //3개를 선택 했다면 n번째 max값을 갱신
			max[n] = Math.max(max[n], sum%10);
			return;
		}
		if(idx >= 5) { //뒤에 카드가 없다면 return
			return;
		}

    //카드 선택
		findMax(n, idx + 1, cnt + 1, sum + arr[n][idx]);
		//카드 선택x
		findMax(n, idx + 1, cnt, sum);
	}
	
}
