package algo;

import java.util.Scanner;

public class Main0314_차이를최대로 {  // 실버2 10819 차이를 최대로
    static int n, max;  
    static int[] a;
    static int[] arr;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a= new int [n];
        arr = new int[n];
        visited = new int[n];
        max = -1;
        
        for(int i=0; i<n; i++) {
        	a[i] = sc.nextInt();
        }
        permutation(0);
        System.out.println(max);
        sc.close();
    }

    private static void permutation(int index) {  // 재귀함수
        if (index == n) {
            int sum = 0; 
            for(int i=0; i<n-1; i++) {
            	sum += Math.abs(arr[i] - arr[i + 1]);
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < n; i++) { 
            if (visited[i]==0) {  
                visited[i] = 1; 
                arr[index] = a[i]; 
                permutation(index + 1); 
                visited[i] = 0; 
            }
        }
    }}
