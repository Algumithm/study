import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        List<Integer> fruit = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            fruit.add(Integer.parseInt(st.nextToken()));
        }

        int start = 0, end = 0, max = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        while (end < N) {
            countMap.put(fruit.get(end), countMap.getOrDefault(fruit.get(end), 0) + 1);
            end++;

            while (countMap.size() > 2) {
                countMap.put(fruit.get(start), countMap.get(fruit.get(start)) - 1);
                if (countMap.get(fruit.get(start)) == 0) {
                    countMap.remove(fruit.get(start));
                }
                start++;
            }

            max = Math.max(max, end - start);
        }

        bw.write(max + "\n");
        bw.flush();
    }
}
