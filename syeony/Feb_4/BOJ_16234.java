import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int n, l, r, avg;
    static int[][] arr;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] v;
    static ArrayList<int[]> li;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        arr=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    static int move(){
        int cnt=0;

        while(true){
            boolean flag=false;
            v=new boolean[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!v[i][j]){
                        int avg=bfs(i,j);
                        if(li.size()>1){
                            flag=true;
                            update(avg);
                        }
                    }
                }
            }
            if(!flag) return cnt;
            cnt++;
        }
    }

    static int bfs(int x, int y){
        int sum=arr[x][y];
        Queue<int[]> q=new LinkedList<>();
        li=new ArrayList<>();
        q.add(new int[]{x,y});
        li.add(new int[]{x,y});
        v[x][y]=true;

        while(!q.isEmpty()){
            int[] c=q.poll();
            int cx=c[0];
            int cy=c[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                if(v[nx][ny]) continue;
                if(l<=Math.abs(arr[nx][ny]-arr[cx][cy]) && Math.abs(arr[nx][ny]-arr[cx][cy])<=r){
                    sum+=arr[nx][ny];
                    v[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                    li.add(new int[]{nx,ny});
                }
            }
        }

        avg=sum/li.size();
        return avg;
    }

    static void update(int avg){
        for(int[] l:li){
            int x=l[0];
            int y=l[1];
            arr[x][y]=avg;
        }
    }
}
