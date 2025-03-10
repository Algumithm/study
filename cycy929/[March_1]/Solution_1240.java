package algo_0310;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Solution_1240
{
    static int n, m, result, line, start;
    static int [][] arr;
    static int [] code;
    static boolean sign;
    static String [] slice;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        String [] pat = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};        
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][m];
            result = 0;
            start = 0;
            line = 0;
            code = new int[56];
            slice = new String[8];
            sc.nextLine();
            
            for (int i = 0; i < n; i++) {
                String lineStr = sc.nextLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = lineStr.charAt(j) - '0';
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    if (arr[i][j] == 1) {
                        line = i;
                        start = j;
                        break;
                    }
                }
            }
            
            int idx = 55;  
            for (int a = start; a > start - 56; a--) {
                if (a >= 0) {
                    code[idx--] = arr[line][a];
                }
            }

            // code 배열을 7개씩 끊어서 slice 배열에 저장
            for (int b = 0; b < 8; b++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < 7; c++) {
                    sb.append(code[b * 7 + c]);
                }
                slice[b] = sb.toString();
            }
            
            int [] codeResult = new int[8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < pat.length; j++) {
                    if (slice[i].equals(pat[j])) {
                        codeResult[i] = j;
                        break;
                    }
                }
            }
            
            if(((codeResult[0]+codeResult[2]+codeResult[4]+codeResult[6])*3+codeResult[1]+codeResult[3]+codeResult[5]+codeResult[7])%10==0) {
           	    for(int i = 0; i<8; i++) {
           		    result += codeResult[i];
               	} 	
            }
            System.out.println("#" + test_case + " " + result);
        }
        sc.close();
    }
}
