package baekjoon;

import java.util.Scanner;

public class Solution_14889 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][]s = new int [n+1][n+1];
		int min = Integer.MAX_VALUE; // 최솟값 초기화
		int index = n*(n-1)/2; //nC2 값
		int [] spl = new int [index];
		int idx = 0;
		
		sc.nextLine();
		
		for(int i=1; i<=n; i++) {  // n*n 배열 입력
			for(int j=1; j<=n; j++) {
				s[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i < n; i++) {  //nC2조합에 해당하는 값들로 경우의수
	        for (int j = i + 1; j <= n; j++) { 
	        	if(i==j)continue;
	        	spl[idx] = s[i][j] + s[j][i];
	        	idx+=1;
	         }
	     }
		
		for(int a:spl) {
			System.out.println(a);  //값이 왜 7개 나오지....?????
		}
		
		for (int i = 0; i < index - 1; i++) {
            for (int j = i + 1; j < index; j++) {
                int diff = 	Math.abs(spl[i] - spl[j]); // 두 값의 차이 계산
                min = Math.min(min, diff);
            }
        }
		
		
		System.out.println(min);
		sc.close();
	}

}
//(1,2) (1,3) (1,4) (2,3) (2,4) (3,4)
//(1,2) (1,3) (1,4) (2,1) (2,3) (2,4) (3,1)(3,2)(3,4) (4,1)(4,2)(4,3)
