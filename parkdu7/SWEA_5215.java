import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int cs = Integer.parseInt(br.readLine());
         
        for (int c = 1; c <= cs; c++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
 
            int[] score = new int[N + 1];
            int[] cal = new int[N + 1];
 
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken()); 
                cal[i] = Integer.parseInt(st.nextToken()); 
            }
 
            int[] dp = new int[L + 1];
 
            for (int i = 1; i <= N; i++) {
                for (int j = L; j >= cal[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - cal[i]] + score[i]);
                }
            }
             
            System.out.println("#" + c + " " + dp[L]);
        }//case
    }//main
}//swea
