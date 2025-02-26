import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1]; // 1-based index 사용
        
        for (int i = 1; i <= n; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (i == j + 1) continue;
                map[i][j + 1] = Integer.parseInt(strs[j]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        combine(n, n / 2, 1, new ArrayList<>(), result);
        
        List<Integer> scores = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        for (List<Integer> a : result) {
            scores.add(getScore(a, map));
        }

        int size = scores.size();
        for (int i = 0; i < size / 2; i++) {
            min = Math.min(min, Math.abs(scores.get(i) - scores.get(size - 1 - i)));
        }

        System.out.println(min);
    }

    public static void combine(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            combine(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    static int getScore(List<Integer> list, int[][] map) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                sum += map[list.get(i)][list.get(j)] + map[list.get(j)][list.get(i)];
            }
        }
        return sum;
    }
}
