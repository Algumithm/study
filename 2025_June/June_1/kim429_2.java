import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            int[] stockPrice = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                stockPrice[i] = Integer.parseInt(st.nextToken());
            }

            long maxPrice = 0;
            long totalProfit = 0;
            
            for (int i= N - 1; i >= 0; i--){
                if (stockPrice[i] > maxPrice){
                    maxPrice = stockPrice[i];
                } else {
                    totalProfit += (maxPrice - stockPrice[i]);
                }
            }
            
            System.out.println(totalProfit);
        }
    }
}
