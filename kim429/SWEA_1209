import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = 1; T <= 10; T++) {
            int test_case = Integer.parseInt(br.readLine());
             
            int N = 100;
            int MAX_SUM = 0;
             
            int[][] matrix = new int[N][N];
             
            for(int i=0; i < N ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sum = 0;
                for(int j = 0; j < N ; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    sum += matrix[i][j];
                    if(MAX_SUM < sum) {
                        MAX_SUM = sum;
                    }
                }
            }
             
            for(int col = 0; col < N ; col++) {
                int row_sum = 0;
                for(int row = 0; row < N ; row++) {
                    row_sum += matrix[row][col];
                    if(MAX_SUM < row_sum) {
                        MAX_SUM = row_sum;
                    }
                }
            }
            int diag_sum = 0;
            int reverse_diag_sum = matrix[0][N-1];
            for(int x = 0; x < N ; x++) {
                diag_sum += matrix[x][x];
                if(MAX_SUM < diag_sum) {
                    MAX_SUM = diag_sum;
                }
                reverse_diag_sum += matrix[x][N-1-x];
                if(MAX_SUM < reverse_diag_sum) {
                    MAX_SUM = reverse_diag_sum;
                }
            }
             
            System.out.println("#" + test_case + " " + MAX_SUM);
        }
        br.close();
    }
}
