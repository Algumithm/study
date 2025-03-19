import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static int n,m;
    static int[][] map;
    static boolean[][] v;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int goalx,goaly;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    goalx=i;
                    goaly=j;
                }
            }
        }
        map[goalx][goaly]=0;
        v=new boolean[n][m];

        bfs(goalx,goaly);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1){
                    if(!v[i][j]){
                        map[i][j]=-1;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void bfs(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {x,y});
        v[x][y]=true;

        while(!q.isEmpty()){
            int[] c=q.poll();
            int cx=c[0];
            int cy=c[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m || v[nx][ny] || map[nx][ny]==0) continue;

                if(map[nx][ny]==1){
                    v[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                    map[nx][ny]=map[cx][cy]+1;
                }
            }
        }
    }
}
