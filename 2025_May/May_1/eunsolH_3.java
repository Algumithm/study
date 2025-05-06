package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16943 {

    static int[] arr;
    static int B;
    static boolean[] visited;
    static int[] perm;
    static int Max=-1;

    static void solve(int idx){
        if(idx==arr.length){
            int sum=0;
            //StringBuilder sb=new StringBuilder();
            for(int j=0;j< arr.length;j++){
                sum=sum*10+perm[j];
            }

            if(sum<B){
                Max=Math.max(Max,sum);
            }

            return;


        }else{
            for(int i=0;i<arr.length;i++){
                if(!visited[i]){
                    if(idx==0 && arr[i]==0){
                        //return;
                        continue;
                    }
                    visited[i]=true;
                    perm[idx]=arr[i];

                    solve(idx+1);
                    visited[i]=false;
                }
            }


        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


        String A= st.nextToken();
        B=Integer.parseInt(st.nextToken());
        arr=new int[A.length()];
        visited=new boolean[A.length()];
        perm=new int[A.length()];


        for(int i=0;i<A.length();i++){
            arr[i]=A.charAt(i)-'0';
        }

        solve(0);
        System.out.println(Max);


    }
}
