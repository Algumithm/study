import java.util.*;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int index = sc.nextInt();
             
            HashMap<Integer, Integer> freq = new HashMap<>();
            int MAX_COUNT = 0;
            int MAX_NUM = 0;
 
            for (int i = 0; i < 1000; i++) {
                int num = sc.nextInt();
                freq.put(num, freq.getOrDefault(num, 0) + 1);
 
                if (freq.get(num) > MAX_COUNT || (freq.get(num) == MAX_COUNT && num > MAX_NUM)) {
                    MAX_COUNT = freq.get(num);
                    MAX_NUM = num;
                }
            }
            System.out.println("#" + index + " " + MAX_NUM);
        }
    }
}
