import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static int n, m;
    static int[][] arr, arr2;
    static int ma=Integer.MIN_VALUE;
    static Queue<int[]> virus;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        arr2=new int[n][m];
        virus=new LinkedList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    virus.add(new int[]{i,j});
                }
            }
        }

        make_wall(0);

        System.out.println(ma);
    }

    static void make_wall(int idx){
        if(idx==3){
            arr2=new int[n][m];
            for(int i=0;i<n;i++){
//                for(int j=0;j<m;j++){
//                    arr2[i][j]=arr[i][j];
//                }
                arr2[i]=arr[i].clone(); //이차원에서의 깊은 복사 방법 2가지 있다.
            }
            bfs();
            ma=Math.max(ma,cnt_0());
            return;
        }

        //벽을 세웠다 안세웠다 하는 코드
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    make_wall(idx+1);
                    arr[i][j]=0;
                }
            }
        }
    }

    static void bfs(){
        Queue<int[]> q2=new LinkedList<>();

        for(int[] v:virus){
            q2.add(v); //깊은복사
        }

        while(!q2.isEmpty()){
            int c[] = q2.poll();
            int x=c[0];
            int y=c[1];

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0||ny<0||nx>=n||ny>=m) continue;

                if(arr2[nx][ny]==1) continue;

                if(arr2[nx][ny]==0){
                    arr2[nx][ny]=2;
                    q2.add(new int[]{nx,ny});
                }
            }
        }
    }

    static int cnt_0(){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr2[i][j]==0) cnt+=1;
            }
        }
        return cnt;
    }

}
