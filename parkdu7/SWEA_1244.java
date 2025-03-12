import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer> list;
    static int swapCount;
    static int max;
    static Set<String> visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cs = Integer.parseInt(br.readLine());
        for (int c = 1; c <= cs; c++) {
            max = Integer.MIN_VALUE;
            list = new ArrayList<>();
            visited = new HashSet<>();
            
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int i = 0; i < s.length(); i++) {
                list.add(Character.getNumericValue(s.charAt(i)));
            }
            swapCount = Integer.parseInt(st.nextToken());

            dfs(0);
            System.out.println("#" + c + " " + max);
        }
    }//main

    static void dfs(int cnt) {
        if (cnt == swapCount) {
            max = Math.max(max, calculate());
            return;
        }

        String state = list.toString();
        if (visited.contains(state)) return;
        visited.add(state);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                swap(i, j);
                dfs(cnt + 1);
                swap(i, j);
            }
        }
    }//dfs

    static void swap(int x, int y) {
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }//swap

    static int calculate() {
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            num = num * 10 + list.get(i);
        }
        return num;
    }//calculate
    
}//swea1244
