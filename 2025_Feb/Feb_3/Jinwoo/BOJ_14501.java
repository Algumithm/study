import java.io.*;
import java.util.*;

public class Main {
    static int N; // 상담 일수
    static int[] T; // 상담 기간
    static int[] P; // 상담 금액
    static int maxProfit = 0; // 최대 수익

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1]; // 상담 기간
        P = new int[N + 1]; // 상담 금액

        // 상담 기간 및 금액 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 완전 탐색 시작
        findMaxProfit(1, 0);
        
        // 결과 출력
        System.out.println(maxProfit);
    }

    // 완전 탐색 함수
    static void findMaxProfit(int day, int profit) {
        // 현재 날짜가 N+1일이 되면 최대 수익 비교
        if (day > N) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        // 상담을 진행하지 않는 경우
        findMaxProfit(day + 1, profit);

        // 상담을 진행하는 경우
        if (day + T[day] - 1 <= N) { // 상담 기간을 넘지 않을 경우
            findMaxProfit(day + T[day], profit + P[day]);
        }
    }
}
