package retest5;

import java.util.*;
public class Main0321_필터{   //백준1895 필터
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] f = new int[9];
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int t = sc.nextInt();
        int[] ans = new int[(n-2)*(m-2)];
        int c = 0;
        int num = 0;
        for(int i = 0; i < n-2; i++){
            c = 0;
            for(int j = 0; j < m-2; j++){
                f[c] = arr[i][j];
                f[c+1] = arr[i][j+1];
                f[c+2] = arr[i][j+2];
                f[c+3] = arr[i+1][j];
                f[c+4] = arr[i+1][j+1];
                f[c+5] = arr[i+1][j+2];
                f[c+6] = arr[i+2][j];
                f[c+7] = arr[i+2][j+1];
                f[c+8] = arr[i+2][j+2];
                Arrays.sort(f); //오름차순
                ans[num] = f[4];
                num++;
            }
        }
        int result = 0;
        for(int i = 0; i < num; i++){
            if(ans[i] >= t)
                result++;
        }
        System.out.println(result);
            
    }
}
