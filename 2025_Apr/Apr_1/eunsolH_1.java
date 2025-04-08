import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int testCase=Integer.parseInt(br.readLine());


        for(int i=0;i<testCase;i++){
            int num=Integer.parseInt(br.readLine());
            int[][] arr=new int[num][2];
            int[] visited=new int[num];
            int cnt=0; //탈락자 count변수

            for(int j=0;j<num;j++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                arr[j][0]=Integer.parseInt(st.nextToken());
                arr[j][1]=Integer.parseInt(st.nextToken());
            }

            //arr[][0] 정렬
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
            int min=Integer.MAX_VALUE;
            for(int j=0;j<num-1;j++){

                min=Math.min(arr[j][1],min);
                //min값보다 크다면 j+1보다 두영역다 등수 높은 사람존재 
                if(min<arr[j+1][1]){
                    cnt++;
                }

            }


            System.out.println(num-cnt);



        }


    }
}
