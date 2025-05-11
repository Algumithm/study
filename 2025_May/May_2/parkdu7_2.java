import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] pa = new long[S];
        long maxLen = 0;
        long totalLen = 0;

        for (int i = 0; i < S; i++) {
            long len = Long.parseLong(br.readLine());
            pa[i] = len;
            totalLen += len;
            maxLen = Math.max(maxLen, len);
        }

        
        long low = 1;
        long high = maxLen;
        long bestLen = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;

            for (long len : pa) { // 몇개 파닭에 넣을 수 있는지 세기
            	cnt += len / mid;
                if (cnt >= C)
                	break;
            }

            if (cnt >= C) {
                bestLen = mid;
                low = mid + 1;
            } else {
            	high = mid - 1;
            }
        }

        long remain = totalLen - bestLen * C;
        System.out.println(remain);
    }
}
