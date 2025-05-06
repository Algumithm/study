package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int tc=Integer.parseInt(br.readLine());

        for(int i=0;i<tc;i++){
            int num=Integer.parseInt(br.readLine());
            int[] arr=new int[num];
            ArrayDeque<Integer> dq=new ArrayDeque<>();




            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<num;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }



            //정렬
            Arrays.sort(arr);

            for(int k=num-1;k>=0;k--){
                if(k%2==1){
                    dq.offerLast(arr[k]);
                }else{
                    dq.offerFirst(arr[k]);
                }
            }

            int pre = dq.pollFirst();
            int diffMax=-1;
            while(!dq.isEmpty()) {
                int cur = dq.pollFirst();
                diffMax = Math.max(diffMax, Math.abs(pre-cur));
                pre=cur;
            }

            System.out.println(diffMax);

        }



    }
}
