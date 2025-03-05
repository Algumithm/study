import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<Integer> tree;
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(st.nextToken()));
        }

        tree.sort(null);
        
        int low = 0;
        int high = tree.get(N - 1);
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long wood = cal(mid);

            if (wood >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }

    static long cal(int h) {
        long sum = 0;
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i) > h) {
                sum += tree.get(i) - h;
            }
        }
        return sum;
    }
}
