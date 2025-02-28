import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_2667 {
    static int n,num;
    static int[][] arr;
    static PriorityQueue<Integer> pq;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        arr=new int[n][n];
        for(int i=0;i<n;i++){
            String line=br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j]=line.charAt(j)-'0'; // 문자 -> 숫자 변환
            }
        }
        pq=new PriorityQueue<>();
        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                num=1;
                if(arr[i][j]==1){
                    bfs(i,j);
                    cnt+=1;
                    pq.add(num);
                }
            }
        }

        System.out.println(cnt);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }

    static void bfs(int x, int y){
        Queue<int[]> q=new LinkedList<>();

        arr[x][y]=0; //이걸로 방문처리 대신함.
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x2=cur[0];
            int y2=cur[1];

            for(int i=0;i<4;i++){
                int nx=x2+dx[i];
                int ny=y2+dy[i];

                if(nx<0||ny<0||nx>=n||ny>=n) continue;

                if(arr[nx][ny]==1){
                    arr[nx][ny]=0;
                    q.add(new int[]{nx,ny});
                    num+=1;
                }
            }
        }

    }
}
