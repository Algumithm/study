import java.util.*;
import java.io.*;

public class Main {
    static class Tree {
        int length, growth;
        public Tree(int length, int growth) {
            this.length = length;
            this.growth = growth;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree[] trees = new Tree[n];
        String[] strs1 = br.readLine().split(" ");
        String[] strs2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(strs1[i]);
            int grow = Integer.parseInt(strs2[i]);
            trees[i] = new Tree(len, grow);
        }

        // 자라는 속도가 느린 나무부터 자르기
        Arrays.sort(trees, Comparator.comparingInt(t -> t.growth));

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += trees[i].length + (long)trees[i].growth * i;
        }

        System.out.println(total);
    }
}
