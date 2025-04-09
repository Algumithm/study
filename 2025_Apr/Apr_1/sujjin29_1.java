import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int arr[][];
    static int sum, max, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int [N][5];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        answer = 0;
        for(int i = 0; i < N; i++) {
            boolean[] visited = new boolean[5];
            combination(visited, 0, 3, i);
        }
        System.out.println(answer+1);
    }
    
    static void combination(boolean[] visited, int start, int r, int i) {
        if(r==0) {
            sum = 0;
            for(int j = 0; j < 5; j++) {
                if(visited[j] == true) {
                    sum += arr[i][j];
                }
            }
            if(max <= (sum % 10) && i >= answer) {
                
                max = (sum % 10);
                answer = i;
            }
            return;
        }
        for(int x = start; x < 5; x++) {
            visited[x] = true;
            combination(visited, x + 1, r - 1, i);
            visited[x] = false;
            
        }