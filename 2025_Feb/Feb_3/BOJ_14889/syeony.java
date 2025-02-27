import java.io.*;
import java.util.*;

public class Main {
    static int n,mi=101;
    static int[][] arr;
    static ArrayList<Integer> start_, link;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr=new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        start_=new ArrayList<>();
        link=new ArrayList<>();

        dfs(0,1);
        System.out.println(mi);

    }

    static void dfs(int depth,int start){
        if(depth>=n/2){
            link.clear(); //link가 차있기 때문에 비워줘야한다. 
            for(int i=0;i<n;i++){
                if(!start_.contains(i)){
                    link.add(i);
                }
            }

            int start_sum=0;
            for(int i=0;i<start_.size()-1;i++){
                for(int j=i+1;j<start_.size();j++){
                    start_sum+=arr[start_.get(i)][start_.get(j)]+arr[start_.get(j)][start_.get(i)];
                }
            }

            int link_sum=0;
            for(int i=0;i<link.size()-1;i++){
                for(int j=i+1;j<link.size();j++){
                    link_sum+=arr[link.get(i)][link.get(j)]+arr[link.get(j)][link.get(i)];
                }
            }

            mi=Math.min(mi,Math.abs(start_sum-link_sum));
            return;
        }

        for(int i=start;i<n;i++){
            start_.add(i);
            dfs(depth+1,i+1); //start+1이 아니라 i+1이다. 
            start_.remove(start_.size()-1);
        }
    }
}
