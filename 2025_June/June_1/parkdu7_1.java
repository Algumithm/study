import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static int[] result = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }

    }

    public static void dfs(int cnt, int idx) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
            	System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < k; i++) {
            result[cnt] = arr[i];
            dfs(cnt + 1, i + 1);
        }
    }
}
