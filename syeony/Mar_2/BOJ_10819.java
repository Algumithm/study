import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_10819 {
    static int n;
    static int[] arr;
    static boolean[] v;
    static int ma;
    static int[] b;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        v=new boolean[n];
        ma=Integer.MIN_VALUE;
        b=new int[n];
        dfs(0);

        System.out.println(ma);
    }

    static void dfs(int idx){
        if(idx==n){
            int temp=0;
            for(int i=0;i<n-1;i++){
                temp+=(Math.abs(b[i]-b[i+1]));
            }
            ma=Math.max(ma,temp);
            return;
        }

        for(int i=0;i<n;i++){
            if(!v[i]){
                v[i]=true;
                b[idx]=arr[i];
                dfs(idx+1);
                v[i]=false;
            }
        }
    }
}
