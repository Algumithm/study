import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
	static int arr[];
	static int N, K;
    static boolean[] robot;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[2 * N];
		robot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		while(!terminate()) {
			cnt++;
			move(); // 회전
			moveRobots(); // 로봇 이동
            putRobot(); // 로봇 놓기
//			debug();
		}
		
		System.out.println(cnt);
	}
	
	static boolean terminate() {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0)
				cnt++;
		}
		
		return cnt >= K;
	}
	
	static void move() {
		int tmp = arr[2*N - 1];
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = tmp;

		for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false;
		
	}
	
	static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && arr[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                arr[i + 1]--;
            }
        }
        robot[N - 1] = false;
    }
	
	static void putRobot() {
        if (arr[0] > 0) {
            robot[0] = true;
            arr[0]--;
        }
    }
	
	static void debug() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
