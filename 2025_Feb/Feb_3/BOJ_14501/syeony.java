import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] day = new int[20];
        int[] pay = new int[20];
        int[] dp = new int[20];

        int n=Integer.parseInt(br.readLine());
        for(int i=1;i<n+1;i++){
            st=new StringTokenizer(br.readLine());
            day[i]=Integer.parseInt(st.nextToken());
            pay[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=n;i>0;i--){
            if(day[i]>n-i+1){ // 1 2 3 4 5 6 7
                dp[i]=dp[i+1];
            }else{
                dp[i]=Math.max(pay[i]+dp[i+day[i]],dp[i+1]);
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
    }
}
