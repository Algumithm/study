import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while(!(line = br.readLine()).equals("0")){
            StringTokenizer st = new StringTokenizer(line);

            int k = Integer.parseInt(st.nextToken());

            int[] s = new int[k];
            for(int i = 0; i < k; i++){
                s[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[k];
            combination(s, visited, 0, k, 6);

            System.out.println();
        }
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r){
        if(r==0){
            print(arr, visited, n);
            return;
        }

        for(int i = start; i < n; i++){
            visited[i] = true;
            combination(arr,visited,i+1,n,r-1);
            visited[i] = false;
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
